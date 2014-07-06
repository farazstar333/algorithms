package linkedList;

import java.util.Hashtable;

/**
 * Created by farazw808 on 7/5/14.
 * This removed duplicates from linked List.
 */
public class LinkedList {


    public static void main(String args[]) {

        // First create a linked list with duplicates.
        // creating head pointer
        Node head = new Node(10);
        for (int counter=0; counter< 20; counter++) {
            head.appendToTail(counter);

        }

        // at this point we know that 10 is duplicate. let add one more for testing.

        head.appendToTail(15);

        //so we are removing 10 and 15 from list.

        // now we will remove these duplicates from linked list. In order to track hash table let use hash table
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();

        Node runner;
        runner= head;
        Node previous=null;
        int j;
        while( runner != null) {
            if( table.get(runner.getValue()) == null){
                table.put(runner.getValue(), runner.getValue() );
                previous= runner;
                runner = runner.next;
            }
            else { // this is removal logic. remove current node by setting next pointer of previous node to next node.
                System.out.println("removing node with value " + runner.getValue()) ;
                runner= runner.next;
                previous.next= runner;



            }


        }


    }




}
