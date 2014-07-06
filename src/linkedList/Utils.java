package linkedList;

/**
 * Created by farazw808 on 7/6/14.
 */
public class Utils {

    public static Node generateLinkedList(int size) {

        // First create a linked list with duplicates.
        // creating head pointer
        Node head = new Node(10);
        //counter=1 because we already have head at 0
        for (int counter=1; counter< size; counter++) {
            head.appendToTail(counter);

        }

        return head;


    }
}
