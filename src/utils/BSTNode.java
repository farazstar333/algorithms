package utils;

/**
 * Created by farazw808 on 5/30/15.
 */
public class BSTNode<T extends Comparable<T>> {
    public T data;
    public BSTNode<T> left;
    public BSTNode<T> right;

    public BSTNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }


}
