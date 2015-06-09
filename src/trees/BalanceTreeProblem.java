package trees;

import utils.BST;
import utils.BSTNode;

/**
 * Created by farazw808 on 7/17/14.
 * Here is problem we need to solve. We have to check that for any node left and right subtree should not be differ more that one
 * Impleemnt a function to check if binary tree is balanced.
 * Tree is balanced is two subtrees are not different by more than one level of depth.
 * Here is psuedocode, use a varaiable to increase measure length when traversing down. always check length returns from-subtrees
 * if they differ by more than one break;
 *
 */
public class BalanceTreeProblem {


    public static void main( String args[]) {

        BST<Integer> tree = new BST<>();
        tree.insert(tree.root,8);
        tree.insert(tree.root,4);
        tree.insert(tree.root,12);
        tree.insert(tree.root,2);
        tree.insert(tree.root,6);
        tree.insert(tree.root,10);
        tree.insert(tree.root,14);
        tree.insert(tree.root,1);
        tree.insert(tree.root,5);
        tree.insert(tree.root,7);
        tree.inOrder(tree.root);





    }








}
