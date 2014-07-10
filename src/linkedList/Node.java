package linkedList;

/**
 * Created by farazw808 on 7/5/14.
 * These algorithms are created for practice and practice solution.
 * These are inspired from career cup
 */
public class Node {

    Object i = 10;
    public Node next = null;

    public Node(Object i) {
        this.i = i;
    }

    public void appendToTail(int j) {

        Node end = new Node(j);
        Node runner = this;
        while (runner.next != null) {

            runner = runner.next;

        }
        //if we reach at this point, it means reach to tail, now it is time to append Node
        runner.next = end;


    }

    public Object getValue() {
        return i;
    }

}
