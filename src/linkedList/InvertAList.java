package linkedList;

/**
 * Created by farazw808 on 8/9/15.
 */
public class InvertAList {


    public static void main(String args[]) {



        LinkedList linkedList = new LinkedList();
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        linkedList.insert(40);
        linkedList.insert(50);
        linkedList.print();
        // now invert the list
        SNode newHead = InvertAList.invertLinkList(linkedList.head);
        linkedList.head = newHead;
        linkedList.print();



    }



    public static  SNode invertLinkList( SNode current ) {

// we will have pointer to previous node, next node and buffer pointer use to save references.
// here is algorithm. set previous pointer to start with. move to next node .
// a> b > c >d >e >f  ------> a< b < c < d < f
// start recursion.
        SNode previous = null;
        SNode next;

        while ( current.next != null ) {
//a is current
            next = current.next;  // b
            current.next=previous; // a's next which will ne null fotr first node
            previous = current;
            current = next;  // now b is current node and next is also b


        }
        current.next=previous; // for last node

        return current;
    }
}
