package linkedList;

/* Given two numbers represented by two linked lists, write a function that returns sum list.
        *
        * Input:
        * First List: 5->6->3  // represents number 563
        * Second List: 8->4->2 //  represents number 842
        * Trick is to inverse each link list and add numbers.  we will use carry in end
        * We will return back resulting linked list
        */
public class AddTwoNumbersUsingLinkedList {


    LinkedList addTwoNumbersUsingLinkedList(LinkedList num1, LinkedList num2){
    num1.reverse();
    num2.reverse();

     SNode cursor1 = num1.head;
     SNode cursor2 = num2.head;
     int carry=0;

// three cases either we are adding both, num1 or num2

     while(cursor1 != null && cursor2 != null) {


     }

     while(cursor1 != null ) {


     }


      while(cursor2 != null) {


      }



        return num2;

    }






}
