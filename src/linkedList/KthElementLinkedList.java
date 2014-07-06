package linkedList;

/**
 * Created by farazw808 on 7/6/14.
 * This program will find kth element from last of linked list
 * Here is algorithm. We need to iterate the linked list in a way that we keep kRunner k elements behind runner.
 * In case K is equal or bigger that n than k will be head
 */
public class KthElementLinkedList {

    public static void main(String args[]) {

        // Let assume that n=30 and k=20

        int counter = 0;
        int k = 8;
        Node head = Utils.generateLinkedList(30);
        Node kRunner = head;
        Node runner = head;
        // Assume we don't know size of linked list. This algorithm needs to be oblivious of it.
        while (runner != null) {
            runner = runner.next;
            counter++;
            if (counter > k) {
                kRunner = kRunner.next; // set KRunner to head which is head at k
            }

        }

        // now test it out. As n=30 and k=8, we will print 8 elements starting from 22

        while (kRunner != null) {

            System.out.println("printing > " + kRunner.getValue());
            kRunner = kRunner.next;


        }

    }

}
