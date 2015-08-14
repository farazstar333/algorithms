package trees;

import utils.BST;
import utils.BSTNode;

/**
 * Created by farazw808 on 6/2/15.
 * The idea is to select mean and make it root. elements before mean, (in order traversal will belong to left and elements after mean will belong to
 * right tree.  Repeat!!
 */
public class SortedArrayToBST {



        // min and max are starting and ending positions within array. we want to avoid copying array to save space
    static void createTreeOfMinimalHeight(int arr[], BST<Integer> tree, int min, int max ){


     if(max == min) tree.insert(tree.root, arr[max]); // just insert the element at position max or min.

     //and mid and divide the array it is 0 base array so add +1
        int mid = (int)Math.ceil( (max-min)/2);  // in case of 8 we will make 4th element as mean. in case of 7 it will be 4


        //Firsts insert the root.
        tree.insert(tree.root, arr[mid+min]);

      // base case, if we have tree of length 2 or less just set them as right and left
        // we need atleast 2 elements
        createTreeOfMinimalHeight(arr, tree,  min,  mid-1 );

        // use array copy and pass subsection of array

        // as java is 0 based array
        createTreeOfMinimalHeight(arr, tree,  mid+1,  max );







    }

    public static void main(String args[]) {


        BST<Integer> tree = new BST<>();
        int[] arr = { 1, 2, 3,4, 7, 9, 12};

        createTreeOfMinimalHeight(arr, tree, 0, arr.length-1);

        // Now do in-order traversal of tree. you should get same order list
        tree.inOrder(tree.root);



    }


}
