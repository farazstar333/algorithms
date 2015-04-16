package linkedList;

/**
 * Created by farazw808 on 7/5/14.
 * These algorithms are created for practice and practice solution.
 * These are inspired from career cup
 */
public class DNode {

    Object i = 10;
    public DNode next = null;
    public DNode previous = null;

    public DNode(Object i) {
        this.i = i;
    }

    public void appendToTail(int j) {

        DNode end = new DNode(j);
        DNode runner = this;
        DNode temp;
        while (runner.next != null) {

            temp=runner;
            runner = runner.next;
            runner.previous = temp; // set current node as previous node for next node

        }
        //if we reach at this point, it means reach to tail, now it is time to append Node
        runner.next = end;



    }

    public Object getValue() {
        return i;
    }

    public DNode next() {
        return this.next;
    }

    public DNode previous() {
        return this.previous;
    }

}
