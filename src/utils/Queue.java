package utils;
import linkedList.Node;

/**
 * Created by farazw808 on 7/9/14.
 */
public class Queue {

    Node first, last;
    Object dequeue() {

        if(first != null) {
            Object item = first.getValue();
            first = first.next;
            if (first == null) last=null;
            return item;

        }
        return null;
    }

    void enqueue(Object item) {
      if(first == null){
          last=new Node(item);
          first=last;
      }
       else{
          last.next = new Node(item);
          last = last.next;
      }

    }


}
