package queuesandstack;

import java.util.Iterator;

/**
 * Created by farazw808 on 11/9/14.
 */
public class Dequeue<T> {

    T list[];
    int head=0; // head pointer
    int tail=0; // tail pointer

    public Dequeue(){
        // create a queue of size 10
        list = (T[])(new Object[10]);
    }                           // construct an empty deque
    public boolean isEmpty()  {
        return (tail == 0);
    }               // is the deque empty?
    public int size() {
        return tail;
    }                       // return the number of items on the deque
    public void addFirst(T item) {

      //  list[counter] = item;

    }         // insert the item at the front
    public void addLast(T item){
        list[tail++] = item;
    }           // insert the item at the end
    public T removeFirst(){
        return list[head];
    }                // delete and return the item at the front
    public T removeLast(){
        return list[tail--];
    }                 // delete and return the item at the end
    public Iterator<T> iterator()  {
        return null;
    }       // return an iterator over items in order from front to end
    public static void main(String[] args) {

    }  // unit testing
}
