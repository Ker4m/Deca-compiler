package fr.ensimag.deca;

import fr.ensimag.deca.codegen.AssError;
import fr.ensimag.deca.codegen.CodeGen;
import fr.ensimag.deca.codegen.StackManager;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.EnvironmentExp.DoubleDefException;
import fr.ensimag.deca.context.EnvironmentType;
import fr.ensimag.deca.context.FieldDefinition;
import fr.ensimag.deca.context.IntType;
import fr.ensimag.deca.syntax.DecaLexer;
import fr.ensimag.deca.syntax.DecaParser;
import fr.ensimag.deca.tools.DecacInternalError;
import fr.ensimag.deca.tools.SymbolTable;
import fr.ensimag.deca.tree.AbstractProgram;
import fr.ensimag.deca.tree.Location;
import fr.ensimag.deca.tree.LocationException;
import fr.ensimag.deca.tree.Visibility;
import fr.ensimag.ima.pseudocode.AbstractLine;
import fr.ensimag.ima.pseudocode.IMAProgram;
import fr.ensimag.ima.pseudocode.Instruction;
import fr.ensimag.ima.pseudocode.Label;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.log4j.Logger;

import java.io.*;

/**
 * Decac compiler instance.
 * <p>
 * This class is to be instantiated once per source file to be compiled. It
 * contains the meta-data used for compiling (source file name, compilation
 * options) and the necessary utilities for compilation (symbol tables, abstract
 * representation of target file, ...).
 * <p>
 * It contains several objects specialized for different tasks. Delegate methods
 * are used to simplify the code of the caller (e.g. call
 * compiler.addInstruction() instead of compiler.getProgram().addInstruction()).
 *
 * @author gl09
 * @date 01/01/2022
 */
public class DecacCompiler {
    private static final Logger LOG = Logger.getLogger(DecacCompiler.class);
    /**
     * Portable newline character.
     */
    private static final String nl = System.getProperty("line.separator", "\n");
    private final CompilerOptions compilerOptions;
    private final File source;
    /**
     * The main program. Every instruction generated will eventually end up here.
     */
    private final IMAProgram program = new IMAProgram();
    private final SymbolTable symbols;
    private final EnvironmentExp envExp;
    private final EnvironmentType envType;
    private final CodeGen codeGenerator;
    private final StackManager sm;
    private Label label;


    public DecacCompiler(CompilerOptions compilerOptions, File source) {
        super();
        this.compilerOptions = compilerOptions;
        this.source = source;

        this.symbols = new SymbolTable();
        this.symbols.create("null");
        this.symbols.create("void");
        this.symbols.create("boolean");
        this.symbols.create("int");
        this.symbols.create("float");
        this.symbols.create("String");
        this.symbols.create("Object");
        this.symbols.create("int[]");
        this.symbols.create("float[]");
        this.envType = new EnvironmentType(this.symbols);
        this.envExp = new EnvironmentExp(null);
        FieldDefinition lengthDef = new FieldDefinition(
                new IntType(this.symbols.create("int")),
                Location.BUILTIN,
                Visibility.PUBLIC,
                null, 0);
        try {
            this.envExp.declare(this.symbols.create("length"), lengthDef);
        } catch (DoubleDefException ignored) {
        }
        FieldDefinition widthDef = new FieldDefinition(
                new IntType(this.symbols.create("int")),
                Location.BUILTIN,
                Visibility.PUBLIC,
                null, 1);
        try {
            this.envExp.declare(this.symbols.create("width"), widthDef);
        } catch (DoubleDefException ignored) {
        }
        this.codeGenerator = new CodeGen(this);
        this.sm = new StackManager(this);
    }

    public CodeGen getCodeGen() {
        return this.codeGenerator;
    }

    public StackManager getStackMan() {
        return sm;
    }

    public SymbolTable getSymbols() {
        return this.symbols;
    }

    public EnvironmentExp getEnvExp() {
        return this.envExp;
    }

    public EnvironmentType getEnvType() {
        return this.envType;
    }

    public Label getLabel() {
        return this.label;
    }

    /**
     * Source file associated with this compiler instance.
     */
    public File getSource() {
        return source;
    }

    /**
     * Compilation options (e.g. when to stop compilation, number of registers
     * to use, ...).
     */
    public CompilerOptions getCompilerOptions() {
        return compilerOptions;
    }

    /**
     * @see fr.ensimag.ima.pseudocode.IMAProgram#add(fr.ensimag.ima.pseudocode.AbstractLine)
     */
    public void add(AbstractLine line) {
        program.add(line);
    }

    /**
     * @see fr.ensimag.ima.pseudocode.IMAProgram#addComment(java.lang.String)
     */
    public void addComment(String comment) {
        if (this.compilerOptions.getComments()) {
            program.addComment(comment);
        }
    }

    /**
     * @see fr.ensimag.ima.pseudocode.IMAProgram#addLabel(fr.ensimag.ima.pseudocode.Label)
     */
    public void addLabel(Label label) {
        program.addLabel(label);
    }

    /**
     * @see fr.ensimag.ima.pseudocode.IMAProgram#addInstruction(fr.ensimag.ima.pseudocode.Instruction,
     * java.lang.String)
     */
    public void addInstruction(Instruction instruction, String comment) {
        program.addInstruction(instruction, comment);
    }

    /**
     * @see fr.ensimag.ima.pseudocode.IMAProgram#addInstruction(fr.ensimag.ima.pseudocode.Instruction,
     * java.lang.String)
     */
    public void addInstruction(Instruction instruction) {
        program.addInstruction(instruction);
    }

    public void addFirst(Instruction i) {
        program.addFirst(i);
    }

    public int getLastInstructionIndex() {
        return program.getSize() - 1;
    }

    public void addInstructionAtIndex(Instruction instruction, int index) {
        program.addAtIndex(instruction, index);
    }

    /**
     * @see fr.ensimag.ima.pseudocode.IMAProgram#display()
     */
    public String displayIMAProgram() {
        return program.display();
    }

    /**
     * Run the compiler (parse source file, generate code)
     *
     * @return true on error
     */
    public boolean compile() {
        String sourceFile = source.getAbsolutePath();
        String destFile = sourceFile.substring(0, sourceFile.length() - 5); // to delete ".deca" from the path
        destFile = destFile.concat(".ass"); // to add ".ass" at the end of the path name

        PrintStream err = System.err;
        PrintStream out = System.out;
        LOG.debug("Compiling file " + sourceFile + " to assembly file " + destFile);
        try {
            return doCompile(sourceFile, destFile, out, err);
        } catch (LocationException e) {
            e.display(err);
            return true;
        } catch (DecacFatalError e) {
            err.println(e.getMessage());
            return true;
        } catch (StackOverflowError e) {
            LOG.debug("stack overflow", e);
            err.println("Stack overflow while compiling file " + sourceFile + ".");
            return true;
        } catch (Exception e) {
            LOG.fatal("Exception raised while compiling file " + sourceFile
                    + ":", e);
            err.println("Internal compiler error while compiling file " + sourceFile + ", sorry.");
            return true;
        } catch (AssertionError e) {
            LOG.fatal("Assertion failed while compiling file " + sourceFile
                    + ":", e);
            err.println("Internal compiler error while compiling file " + sourceFile + ", sorry.");
            return true;
        }
    }

    /**
     * Internal function that does the job of compiling (i.e. calling lexer,
     * verification and code generation).
     *
     * @param sourceName name of the source (deca) file
     * @param destName   name of the destination (assembly) file
     * @param out        stream to use for standard output (output of decac -p)
     * @param err        stream to use to display compilation errors
     * @return true on error
     */
    private boolean doCompile(String sourceName, String destName,
                              PrintStream out, PrintStream err)
            throws DecacFatalError, LocationException {

        /* Etape A */
        AbstractProgram prog = doLexingAndParsing(sourceName, err);

        if (prog == null) {
            LOG.info("Parsing failed");
            return true;
        }
        assert (prog.checkAllLocations());

        if (compilerOptions.getParse()) { // -p option
            prog.decompile(System.out);
            return false; // no error
        }

        /* Etape B */
        prog.verifyProgram(this);
        assert (prog.checkAllDecorations());

        if (compilerOptions.getVerif()) { // -v option
            return false; // no error
        }

        /* Etape C */
        getCodeGen().setRmax(compilerOptions.getX()); // -r X option
        prog.codeGenProgram(this);
        addComment("");
        AssError.addErrorAtEndOfFile(this);
        LOG.debug("Generated assembly code:" + nl + program.display());
        LOG.info("Output file assembly file is: " + destName);

        FileOutputStream fstream;
        try {
            fstream = new FileOutputStream(destName);
        } catch (FileNotFoundException e) {
            throw new DecacFatalError("Failed to open output file: " + e.getLocalizedMessage());
        }

        LOG.info("Writing assembler file ...");

        program.display(new PrintStream(fstream));
        LOG.info("Compilation of " + sourceName + " successful.");
        return false;
    }

    /**
     * Build and call the lexer and parser to build the primitive abstract
     * syntax tree.
     *
     * @param sourceName Name of the file to parse
     * @param err        Stream to send error messages to
     * @return the abstract syntax tree
     * @throws DecacFatalError    When an error prevented opening the source file
     * @throws DecacInternalError When an inconsistency was detected in the
     *                            compiler.
     */
    protected AbstractProgram doLexingAndParsing(String sourceName, PrintStream err)
            throws DecacFatalError, DecacInternalError {
        DecaLexer lex;
        try {
            lex = new DecaLexer(CharStreams.fromFileName(sourceName));
        } catch (IOException ex) {
            throw new DecacFatalError("Failed to open input file: " + ex.getLocalizedMessage());
        }
        lex.setDecacCompiler(this);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        DecaParser parser = new DecaParser(tokens);
        parser.setDecacCompiler(this);
        return parser.parseProgramAndManageErrors(err);
    }

}
