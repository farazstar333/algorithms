package linkedList;

import java.util.Hashtable;

/**
 * Created by farazw808 on 7/5/14.
 * This removed duplicates from linked List.
 */
public class LinkedList {

    public SNode head;

    public void insert(int data){
        SNode cursor = head ;
        SNode newNode = new SNode(data,null);
        if(cursor == null){
            head = newNode;
            return;
        }

        while(cursor.next!=null){
            cursor = cursor.next;
        }
        cursor.next = newNode;

    }

    /**
     * please remember this version..
     * take care of the first node case
     * @param data
     */
    public void remove(int data){
        SNode current = head;
        SNode previous = null;

        while(current!=null){
            if(current.data == data) {
                if(previous !=null) {
                    previous.next = current.next;
                } else {
                    head = head.next;
                }
                current = current.next;
            } else {
                previous = current;
                current = current.next;
            }
        }
    }

       /**
     * always use this method to reverse
     */
    public void reverse(){


        SNode reverse =null;

        while(head != null) {

            SNode next= head.next;
            head.next=reverse;
            reverse = head;

            head=next;


        }
        head=reverse; // set head to reverse node. it mean next node was null and head should be previous node.


    }

    public void duplicates() {

    }


    public void print(){
        SNode cursor = head;
        while(cursor!=null){
            System.out.println(cursor.data);
            cursor = cursor.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.print();

        list.reverse();

        System.out.println("After reversing the list: ");

        list.print();


    }
}
