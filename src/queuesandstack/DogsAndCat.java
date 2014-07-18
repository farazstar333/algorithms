package queuesandstack;

import linkedList.Node;
import utils.Queue;

import java.util.Date;

/**
 * Created by farazw808 on 7/12/14.
 * This is queue for mantaining dogs and cats.
 * We can have pointers like head and tail and extra pointers dog head and cat head
 * We just needs two queues, one for cat and one for dog.
 */
public class DogsAndCat {

    Node head;
    Queue dogs;
    Queue cats;
    Date dogsstamp; // we will keep it dogs last timestamp;
    Date catstamp;  // we will keep it to cats timestamp;


    public void enqueue(Pet pet) {

    }


}
