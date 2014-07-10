package utils;

import linkedList.Node;

/**
 * Created by farazw808 on 7/9/14.
 */
public class Stack {

    Node top;
    Object pop() {

        if(top != null) {
            Object value = top.getValue();
            top = top.next;
            return value;

        }
        return null;
    }

    void push(Object value) {
        Node node = new Node(value);
        node.next=top;
        top = node; // it will become new top

    }

    Object peek() {
        return top.getValue();
    }
}
