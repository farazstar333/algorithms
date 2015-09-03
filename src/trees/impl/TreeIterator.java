package trees.impl;

import java.util.Stack;

/**
 * Created by farazw808 on 8/16/15.
 * Create an iterator for tree
 * condition is to do next and hasNext() in O(1) time and uses 0(h) memory.
 */

class TreeNode {

    TreeNode left;
    TreeNode right;
    int data;

    TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

}

class Tree {

    TreeNode root;

    public TreeNode insert(TreeNode node, int data) {

        if (node == null) {
            node = new TreeNode(data);
            if (root == null) root = node;
        } else if (node.data >= data)
            node.left = insert(node.left, data);
        else
           node.right = insert(node.right, data);

        return node;
    }

    public TreeIterator iterator() {

        return new TreeIterator(this.root);
    }


}

/**
 * Tree iterator provides next and hasNext()
 */
public class TreeIterator {

    TreeNode current;
    Stack<TreeNode> nodesStack = new Stack<>();

    public TreeIterator(TreeNode treeNode) {


        //go to smallest element and push parent nodes in stack
        while (treeNode != null) {

            nodesStack.push(treeNode); // push father into stack
            treeNode = treeNode.left; // set left node as current node


        }



    }

    public boolean hasNext() {

        // if stack is empty it means there is no more element

        return !nodesStack.empty();
    }

    public TreeNode next() {

        // now pop the stock
        TreeNode toReturn = nodesStack.pop();



            TreeNode parent = nodesStack.peek();
            //first visit right of parent
            if(parent.right != null)
            {       nodesStack.push(parent.right);
                    TreeNode current = null;

            }

            // now we will go left nodes




        return toReturn;

    }

    public static void main(String args[]) {

        Tree tree = new Tree();
        tree.insert(tree.root, 5);
        tree.insert(tree.root, 8);
        tree.insert(tree.root, 6);
        tree.insert(tree.root, 3);
        tree.insert(tree.root, 2);
        tree.insert(tree.root, 4);

       // first see if we can do in-order traversal without recursion. we will use same concept in iterator
       Stack<TreeNode> nodeStack = new Stack();
       TreeNode root = tree.root;
       while(!nodeStack.empty() && root != null ) {

           if(root.left != null)
           {
               nodeStack.push(root.left);
              root=root.left;
           }
           else{ // it means there is no more root element to traverse. push it from stack and
               System.out.println();

           }


       }


    }


}
