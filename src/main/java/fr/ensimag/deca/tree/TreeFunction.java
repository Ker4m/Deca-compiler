package fr.ensimag.deca.tree;

/**
 * Function that takes a tree as argument.
 *
 * @author gl09
 * @date 01/01/2022
 * @see fr.ensimag.deca.tree.Tree#iter(TreeFunction)
 */
public interface TreeFunction {
    void apply(Tree t);
}
