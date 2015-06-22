package sorting;

/**
 * Created by farazw808 on 6/13/15.
 */
public class QuickSort {


    public static void main(String args[]) {

        int[] list = {34, 12, 67, 80, 55, 32, 10, 5, 45, 20, 60, 22};


        quickSort(list, 0, list.length - 1); // it is 0 base index

        System.out.println(list);

    }

    /**
     * This will call itself recursivley untill array is sort
     *
     * @param array
     * @param start
     * @param end
     */

    public static void quickSort(int[] array, int start, int end) {


        // base case. if this condition is true, we have 1 element array and no need to sort it.
        if (start < end) {

            // int randIndex = (int)(Math.random() * (start - end-1)); // java is 0 base index. for array of length 1 we should get 0

            int wall = partition(array, start, end);  // otherwise partition it and get index of wall
            // partition the array around pivot and get index of partition wall.
            quickSort(array, start, wall - 1); //0, -1   worst case
            quickSort(array, wall + 1, end); // worst case is that wall don't move as array is in sorted condition and we will start from 1 next time.


        }


    }


    public static int partition(int[] array, int start, int end) {

        // we can use any random element as well.
        int pivot = array[end];
        int wall = start;
        // now iterate through array and compare with pivot
        for (int counter = start; counter < end; counter++) {

            if (array[counter] < pivot) { // it means it needs to be moved to left of wall. we will drop  pivot as well.

                // exchange it with first element after wall.
                int temp = array[wall];
                array[wall] = array[counter];
                array[counter] = temp;
                // increament the wall to point to next element.
                wall++;
            }

        }

        // now drop pivot

        int buff = array[wall];
        array[wall] = pivot;
        array[end] = buff;

        return wall;
    }


}
