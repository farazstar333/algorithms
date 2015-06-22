package trees;

/**
 * Created by farazw808 on 6/15/15.
 */
public class Heap {

    int next = 1;  // for simplification  start from position 1
    // for left node we will use 2J, for right node we will use 2J + 1 where J is index of parent node and 1 is root
    int[] list = null; //

    public static void main(String args[]) {

        Heap heap = new Heap(15);

        // add elements in heap and see how they fit

        heap.insert(9);
        heap.insert(4);
        heap.insert(10);
        heap.insert(6);
        heap.insert(12);
        heap.insert(22);
        heap.insert(5);
        heap.insert(5);
        heap.insert(6);


        System.out.println(heap.getHeap());

        // now pop and see if remaining tree is still heap.

        heap.pop();

        System.out.println(heap.getHeap());

        heap.pop();

        System.out.println(heap.getHeap());

        heap.pop();

        System.out.println(heap.getHeap());

    }

    public Heap(int size) {

        list = new int[size]; // create a heap of size n.

    }

    public void insert(int element) {

        list[next] = element; // first set element at next available position in heap.
        fixUp(next); //
        next++;


    }
    // we can only remove from top

    public int pop() {

        int head = list[1]; // we will remove head.

        // now move last element at head and decrease next pointer
        int temp =list[--next];
        list[1] = temp;
        list[next] = -1; // this position should be fill be -1


        // now move down heap to check.
        fixDown(1);

        return head;

    }

    private void fixDown(int index) {

        // base case. if are at next then it means we went back all the way to last element ans no need to do further siftDown
        if (index == next) return;

        // first compare which child is bigger. we will exchange with that.
        int leftChildI = 2 * index;
        int rightChildI = 2 * index + 1;

        if (rightChildI >= next || leftChildI >= next) // meaning there is no left or right child just return
            return;

        if (rightChildI >= next || list[leftChildI] > list[rightChildI])  // so we have left child but no right child or left is bigger
        {
            swapAndFixDown(index, leftChildI);
        }
        // it means we have both left and right childs. we need to compare if right is bigger that left.
        else if (list[rightChildI] > list[leftChildI]) {

            swapAndFixDown(index, rightChildI);
        }


    }

    private void swapAndFixDown(int parentIndex, int childIndex) {

        if (list[parentIndex] < list[childIndex]) {

            swap(parentIndex, childIndex);
            fixDown(childIndex);

        }


    }

    private void fixUp(int nodeIndex) {

        // base case. if we are at position 1 it means that we are at
        if (nodeIndex == 1) return; // we are at good.
        // check the last element we added and see if it violates heap property. if it does then exchange it with its parent.

        // first find out if we are at odd or even node. even nodes are left and odd are right.
        // For even nodes parent is next/2. for odd it is next/2 -1;
        int parentIndex = findParentIndex(nodeIndex);
        if (list[nodeIndex] > list[parentIndex]) {
            swap(nodeIndex, parentIndex);
            fixUp(parentIndex);

        }


    }


    private int findParentIndex(int childIndex) {


        return (int) (childIndex / 2);


    }

    int[] getHeap() {

        return list;

    }

    // swap positions ind1 and ind2
    private void swap(int ind1, int ind2) {

        int temp = list[ind1];
        list[ind1] = list[ind2];
        list[ind2] = temp;


    }

}
