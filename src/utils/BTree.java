package utils;

/**
 * Created by farazw808 on 7/17/14.
 */
public class BTree {

    public Object value;
    public BTree left;
    public BTree right;


    public void preOrder(BTree tree) {
    if (tree == null)  return ;
      visit(tree);
        preOrder(tree.left);
        preOrder(tree.right);

    }

    public void inOrder(BTree tree) {
        if (tree == null)  return ;

        inOrder(tree.left);
        visit(tree);
        inOrder(tree.right);

    }

    public void postOrder(BTree tree) {
        if (tree == null)  return ;

        postOrder(tree.left);
        postOrder(tree.right);
        visit(tree);
    }

    public void visit(BTree tree) {

        System.out.println("The value of node is " + tree.value);
        return ;
    }



}
