package trees;

import utils.BST;
import utils.BSTNode;

/**
 * Created by farazw808 on 6/21/15.
 */
public class CommonAncestor<T extends Comparable<T>> {



    public static void main(String args[]) {

        BST<Integer>  bstTree  = new BST<Integer>();

        BSTNode<Integer> root = bstTree.insert(null, 9);
        bstTree.insert(root, 4);
        bstTree.insert(root, 10);
        bstTree.insert(root, 6);
        bstTree.insert(root, 12);
        bstTree.insert(root, 22);
        bstTree.insert(root, 5);
        bstTree.insert(root, 5);
        bstTree.insert(root, 6);

        // add elements in heap and see how they fit

        // now find common ancestor of 4 and 12



        CommonAncestor<Integer> commonAncestor = new CommonAncestor();
        BSTNode<Integer> node = commonAncestor.findCommonAncestor(root, new BSTNode<Integer>(4), new BSTNode<Integer>(12));

        System.out.println("common ancestor found is " + node);


    }

    /**
     * This will return null if no node is found
     * node1 is only node1 is found
     * node2 if only node2 is found
     * if return value is neither of above it means then it is common ancestor
     *
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    BSTNode<T> findCommonAncestor(BSTNode<T> root, BSTNode<T> node1, BSTNode<T> node2) {


        // base case.
        if (root == null) return null;

        if (root.equals(node1)) return node1;

        if (root.equals(node2)) return node2;
        // end of base case

        // recursive case

        BSTNode<T> nodeFromLeft = findCommonAncestor(root.left, node1, node2);

        if (nodeFromLeft != null && nodeFromLeft != node1 && nodeFromLeft != node2) // it means we find a common ancestor and return now.
            return nodeFromLeft;

        BSTNode<T> nodeFromRight = findCommonAncestor(root.right, node1, node2);

        if (nodeFromRight != null && nodeFromRight != node1 && nodeFromRight != node2) // it means we find a common ancestor and return now.
            return nodeFromRight;

        // now if we have not null values for both nodes then it means current node is

        if (nodeFromRight != null && nodeFromLeft != null)
            return root; // it means current node is common ancestor

        if (nodeFromRight != null)
            return nodeFromLeft;

        if (nodeFromLeft != null)
            return nodeFromRight;

        return null;


    }

}
