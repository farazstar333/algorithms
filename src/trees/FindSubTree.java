package trees;

import utils.BSTNode;

/**
 * Created by farazw808 on 6/22/15.
 * This is problem we are trying to solve.
 * Given a bigger tree and smaller tree or vice versa, we will find out if T1 belongs to T2(T2 being bigger one or target tree) and T1
 * we want to find out
 */
public class FindSubTree<T extends Comparable<T>> {

    /**
     * Here is algorithm.
     * T2 is our target tree in which we want to find out T1
     * @param T1
     * @param T2
     * @return
     */
    boolean findSubTree(BSTNode<T> T1, BSTNode<T> T2) {

        // find root node in T2 by binary search. if find out in T2 then start in-order traversal of both tree and return tree if T1
        // is fully traversed

        return true;


    }


}
