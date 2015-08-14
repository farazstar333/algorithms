package trees;
import java.io.*;
import java.util.ArrayDeque;
/**
 * Created by farazw808 on 8/14/15.
 */

class TreeNode{

    TreeNode left=null;
    TreeNode right=null;
    int data;


}
 class Tree{
    TreeNode root;

    public TreeNode addNode(TreeNode node, int data) {


        if(node == null) // create root and assign new node as root.abstract
        { node = new TreeNode();
            node.data = data;
            if(root == null) root = node;

        }
        else
        {
            if( data > node.data) {
                node.right = addNode(node.right, data);
            }
            else
            if(data <= node.data) {
                node.left = addNode(node.left, data);
            }
        }

        return node;

    }
    /**
     print Tree by pre-order traversal
     */
    public void printTree(TreeNode node) {

        if(node == null) return;

        System.out.print(  node.data + " , ");
        printTree(node.left);
        printTree(node.right);


    }

    /**
     Start from root node or given node and traverse the tree level by level.
     It is Breath first traversal with one caveat that we will mantain line delim to
     help us print out
     */
    public void traverseAndPrintLevel(TreeNode root) {
        TreeNode delim = new TreeNode(); // it will be use as delim

        if (root == null) return;

        //put root node in queue + delimeter
        ArrayDeque<TreeNode> arrayDequue = new ArrayDeque<>();
        arrayDequue.add(root); // add root to queue. Now also add a delimeter
        arrayDequue.add(delim); // add null for line delimeter. this special node stand for null

        //iterate as long as queue is not empty
        while(!arrayDequue.isEmpty()) {

            TreeNode node = arrayDequue.pop();
            if(node != delim) {
                System.out.print(node.data + " ");
                // push childrens of node to queue. check if they are not null before adding

                if(node.left != null) arrayDequue.add(node.left);
                if(node.right != null) arrayDequue.add(node.right);
            }
            else
            { System.out.println("");
                // add another null to queue because we want to mantain level boundry by null make sure that queue size is not zero
                // because it means we have already visited all nodes and needs to end
                // push node childrens to queue.
               if (!arrayDequue.isEmpty()) arrayDequue.add(delim);
            }


        }



    }

}
public class LevelOrderWithNewLineTraversal {

    /**
     This is driver program and will be used in tests.
     */
    public static void main (String[] args) throws java.lang.Exception
    {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String input = br.readLine();
        System.out.println("hello world");
        Tree tree = new Tree();
        tree.addNode(tree.root, 5);
        tree.addNode(tree.root, 7 );
        tree.addNode(tree.root, 9 );
        tree.addNode(tree.root, 4 );
        tree.addNode(tree.root, 3 );
        tree.addNode(tree.root, 2 );
        tree.addNode(tree.root, 12 );

        tree.printTree(tree.root);

        System.out.println("Now doing traveral of tree level by level");

        tree.traverseAndPrintLevel(tree.root);

    }

}
