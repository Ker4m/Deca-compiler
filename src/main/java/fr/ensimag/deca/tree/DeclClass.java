package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.*;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.LabelOperand;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.LEA;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.STORE;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

/**
 * Declaration of a class (<code>class name extends superClass {members}<code>).
 *
 * @author gl09
 * @date 01/01/2022
 */
public class DeclClass extends AbstractDeclClass {
    private final AbstractIdentifier nameClass;
    private final AbstractIdentifier nameSuper;
    private final ListDeclMethod methods;
    private final ListDeclField fields;

    public DeclClass(AbstractIdentifier nameClass, AbstractIdentifier nameSuper, ListDeclMethod methods, ListDeclField fields) {
        Validate.notNull(nameClass);
        Validate.notNull(nameSuper);
        Validate.notNull(methods);
        Validate.notNull(fields);
        this.nameClass = nameClass;
        this.nameSuper = nameSuper;
        this.methods = methods;
        this.fields = fields;
    }

    public AbstractIdentifier getIdClass() {
        return this.nameClass;
    }

    public AbstractIdentifier getIdSuperClass() {
        return this.nameSuper;
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print("class ");
        this.nameClass.decompile(s);
        if (!(this.nameSuper.getName().getName().equals("Object"))) {
            s.print(" extends ");
            this.nameSuper.decompile(s);
        }
        s.println(" {");
        s.indent();
        this.fields.decompile(s);
        this.methods.decompile(s);
        s.unindent();
        s.println("}");
    }

    @Override
    protected void verifyClass(DecacCompiler compiler) throws ContextualError {

        ClassType superClassAsClassType = this.nameSuper.verifyType(compiler).asClassType("name of the " +
                        "provided super Class is not a correct Class name : " + this.nameSuper.getName().getName(),
                getLocation());

        ClassDefinition superClassDef = (ClassDefinition) compiler.getEnvType().getType(compiler.getSymbols().create(this.nameSuper.getName().getName()));

        ClassType classAsClassType = new ClassType(this.nameClass.getName(), this.getLocation(), superClassDef);
        classAsClassType.getDefinition().asClassDefinition("Definition can not be converted to ClassDefinition", this.getLocation()).setDeclClass(this);

        if (!classAsClassType.isSubClassOf(superClassAsClassType)) {
            throw new ContextualError("The name of the provided super Class is not a super class of Class " +
                    "named : " + this.nameSuper.getName().getName(), getLocation());
        }

        EnvironmentExp environmentExp = compiler.getEnvExp();
        ExpDefinition classDef = this.nameClass.getExpDefinition();
        TypeDefinition classType = this.nameClass.getClassDefinition();
        EnvironmentType envType = compiler.getEnvType();

        envType.setType(classAsClassType.getName(), classType);
        envType.setType(this.nameSuper.getName(), this.nameSuper.getClassDefinition()); // Correspond à la passe 2 à vérifier
        this.nameClass.setDefinition(classDef);

        try {
            environmentExp.declare(compiler.getSymbols().create(this.nameClass.getName().getName()), classDef);
        } catch (EnvironmentExp.DoubleDefException e) {
            throw new ContextualError("Class " + this.nameClass.getName().getName() + " is already declared.",
                    getLocation());
        }
        compiler.getEnvType().setType(compiler.getSymbols().create(this.nameClass.getName().getName()), classAsClassType.getDefinition());
        this.nameClass.setDefinition(classAsClassType.getDefinition());
        this.nameClass.setType(classAsClassType);
    }

    @Override
    protected void verifyClassMembers(DecacCompiler compiler)
            throws ContextualError {
        // La super class a déjà été ajouté dans l'environnement en passe 1 --> vérifier le localEnv

        ClassDefinition currentClass = (ClassDefinition) compiler.getEnvType().getType(compiler.getSymbols().create(this.nameClass.getName().getName()));
        this.fields.verifyListFieldMembers(compiler, compiler.getEnvExp(), currentClass);
        this.methods.verifyListMethodMembers(compiler, compiler.getEnvExp(), currentClass);
    }

    @Override
    protected void verifyClassBody(DecacCompiler compiler) throws ContextualError {

        ClassDefinition currentClass = (ClassDefinition) compiler.getEnvType().getType(compiler.getSymbols().create(this.nameClass.getName().getName()));
        this.fields.verifyListFieldBody(compiler, compiler.getEnvExp(), currentClass);
        this.methods.verifyListMethodBody(compiler, compiler.getEnvExp(), currentClass);
    }


    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        nameClass.prettyPrint(s, prefix, false);
        nameSuper.prettyPrint(s, prefix, false);
        fields.prettyPrint(s, prefix, false);
        methods.prettyPrint(s, prefix, true);
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        this.nameClass.iter(f);
        this.nameSuper.iter(f);
        this.fields.iter(f);
        this.methods.iter(f);
    }

    @Override
    protected void codeGenDeclClass(DecacCompiler compiler) {
        compiler.addComment("");
        compiler.addComment("====================================================");
        compiler.addComment("                  CLASS " + nameClass.getName());
        compiler.addComment("====================================================");
        compiler.addComment("");
        compiler.addComment("~~~~~~~~~~~ Initialization of fields ~~~~~~~~~~~~~~~");
        compiler.addLabel(new Label("init." + nameClass.getName()));
        compiler.getCodeGen().setCurClass(this);
        fields.codeGenListDeclFields(compiler);
        compiler.addComment("~~~~~~~~~~~ Initialization of Methods ~~~~~~~~~~~~~~");
        methods.codeGenListDeclMethods(compiler);
    }

    @Override
    public void codeGenMethodTable(DecacCompiler compiler) {

        ClassDefinition classDef = nameClass.getClassDefinition();
        compiler.addComment("Construction de la table des méthodes de " + nameClass.getName().getName());
        classDef.setOperand(new RegisterOffset(compiler.getCodeGen().getIndexGB(), Register.GB));
        compiler.getCodeGen().incrIndexGB();

        compiler.addInstruction(new LEA(classDef.getSuperClass().getOperand(), Register.R0));
        compiler.addInstruction(new STORE(Register.R0, classDef.getOperand()));

        compiler.addInstruction(new LOAD(new LabelOperand(new Label("code.Object.equals")), Register.R0));
        compiler.addInstruction(new STORE(Register.R0, new RegisterOffset(compiler.getCodeGen().getIndexGB(), Register.GB)));
        compiler.getCodeGen().incrIndexGB();

        for (AbstractDeclMethod am : methods.getList()) {
            DeclMethod m = (DeclMethod) am;
            m.getIdMethod().getMethodDefinition().setLabel(new Label("code." + nameClass.getName().getName() + "." + m.getIdMethod().getName().getName())); // code.Class.method -> ex: code.A.m()
            m.getIdMethod().getMethodDefinition().genCodeDef(compiler);
        }
    }

    protected ListDeclMethod getListDeclMethod() {
        return this.methods;
    }

    protected ListDeclField getListDeclField() {
        return this.fields;
    }
}
