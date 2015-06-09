package linkedList;

/**
 * Created by farazw808 on 7/6/14.
 * This program will find kth element from last of linked list
 * Here is algorithm. We need to iterate the linked list in a way that we keep kRunner k elements behind runner.
 * In case K is equal or bigger that n than k will be head
 */
public class KthElementLinkedList {


    public static void main(String[] args) {

        LinkedList testList = new LinkedList();

        testList.insert(7);
        testList.insert(4);
        testList.insert(2);
        testList.insert(9);
        testList.insert(11);
        testList.insert(12);
        testList.insert(0);


        SNode kFind = null;
        // let assume k=2  once we reach k distance from begining we will update k node
        SNode cursor= testList.head;
       int k=6; int counter=0;
        while(cursor != null) {

            if(( counter > k) ) {
                kFind = kFind.next;
            }
            else if(counter == k) {
                kFind= testList.head;
            }
            counter++;
            cursor = cursor.next;
        }

        System.out.println("cursor node value id " + kFind.data);

    }

}
