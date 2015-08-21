package linkedList;

/**
 * Created by farazw808 on 7/9/14.
 * Create algorithm which finds out if given list is circular or not.
 * Are we given head or any node member. The problem is solvable in O(n) time.
 * It is classic tricky problem. We dont know where list loop itself and we need to find that node is.
 * This problem will be solved by two running pointers, one of which is 2X faster than first.
 */
public class CircularList {


    public static void main(String args[]) {

        // here is driver program.


      



    }

    boolean findCycle(SNode head) {

        boolean cycle = false;
        if (head == null) return false;
        SNode slowPointer = head;
        SNode fastPointer = head;

        while (slowPointer.next != null) {

            if (fastPointer.next.next == null) {
                return false;
            }


            if (fastPointer == slowPointer) return true;

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }


        return false;
    }


}
