package utils;

/**
 * Created by farazw808 on 7/17/14.
 */
public class BTree {

    public int value;
    public BTree left;
    public BTree right;

    /**
     * This will be head of tree. Rest of tree can be created using setValue
     * @param value
     */
    public BTree(int value) {

        this.value= value;
        left=null;
        right=null;

    }


    public void preOrderTraverse(BTree tree) {
    if (tree == null)  return ;
      visit(tree);
        preOrderTraverse(tree.left);
        preOrderTraverse(tree.right);

    }

    public void inOrderTraverse(BTree tree) {
        if (tree == null)  return ;

        inOrderTraverse(tree.left);
        visit(tree);
        inOrderTraverse(tree.right);

    }

    public void postOrderTraverse(BTree tree) {
        if (tree == null)  return ;

        postOrderTraverse(tree.left);
        postOrderTraverse(tree.right);
        visit(tree);
    }

    public void visit(BTree tree) {

        System.out.println("The value of node is " + tree.value);
        return ;
    }

    // do it in in-order.  This is how it should be. Left most node should be greatest in value
    public void setValue(int value ){


      if( value >= this.value )
      {
          if (left == null)
              left = new BTree(value);
          else
              left.setValue(value);
      }
        else {

          if(right == null)
              right = new BTree(value);
          else

            right.setValue(value);
      }



    }


}
