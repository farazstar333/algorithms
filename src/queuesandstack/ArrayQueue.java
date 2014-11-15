package queuesandstack;

import java.util.Iterator;

/**
 * Created by farazw808 on 11/10/14.
 * This is implementation of stack using array
 * It uses circular array to implement a stack.
 * One pointer maintain tail and other head.
 */
public class ArrayQueue<T> {


    T list[];
    int head = -1; // head pointer
    int tail = 0; // tail pointer

    public ArrayQueue() {
        // create a queue of size 10
        list = (T[]) (new Object[5]);
    }             // construct an empty deque

    public int capacity() {
        return list.length;
    }


    // return the number of items on the deque

    public void queue(T item) {


        if ((tail == head)) // if tail is equal to head after ++ it means it need resizing and our queue is full.
            resize(); // if element count is same as list size. the queue can not be empty
        tail = tail % list.length;
        list[tail++] = item;

    }

    public T dequeue() throws Exception {
        if (tail == head) throw new Exception("stack is empty");
        head++;
        head = head % list.length;// normalize head pointer as it is circular queue with array.
        T buffer =list[head];
        list[head] = null;
        return buffer;
    }

    public T getTop() throws Exception {
        if ((tail == head)) throw new Exception("stack is empty");
        head = head % list.length;
        return list[head]; // we are not changing the pointer.
    }

    private void resize() {
        // double the size
        T listOld[] = list;
        list = (T[]) (new Object[2 * listOld.length]); // increase the size of list by 2 times.
        int tailPointer = 0;
        // now we need to copy old array to new in way that head gets at position 0 and tail at n+1 th element of last array. we need to copy elements accordingly
        head++; // we will point to next element
        for (int counter = 0; counter < listOld.length-1; counter++) {
            // head will be at position 0. we will move all elemnts in order untill nth element of old queue

            if (head <= listOld.length-1)
                list[counter] = listOld[head++];
            else // once we are done with elements after head, we will add elements from 0 to head.
                list[counter] = listOld[tailPointer++];
        }
        // now reset head and tail pointer
        head = -1;
        // as we resized. we need to put tail at next position which will be start of previous list + 1
        tail = listOld.length; // so it points to next position in
    }

    public Iterator<T> iterator() {
        return null; // not supported
    }       // return an iterator over items in order from front to end

    public static void main(String[] args) {

        // first push element in stock
        ArrayQueue<String> queue = new ArrayQueue();
        queue.queue("1");
        queue.queue("2");
        queue.queue("3");

        // now pop it. we should get reverse order

        try {
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        // now add more item to verify resizing property.
        queue.queue("4");
        queue.queue("5");
        queue.queue("6");
        queue.queue("7");
        queue.queue("8");
        queue.queue("9");

        // get top
        try {

            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());

        } catch (Exception exp) {
            exp.printStackTrace();
        }


    }  // unit testing


}
