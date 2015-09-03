package sorting;

/**
 * Created by farazw808 on 8/19/15.
 */
public class QuickSort2 {

    public static void main(String args[]) {

        // bubble sort an array like { 5, 7,20, 9, 2, 22, 45, 100, 40, 30, 78, 12, 100, 14, 62 }

        int  input[] = { 5, 7,20, 9, 2, 22, 45, 100, 40, 30, 78, 12, 100, 14, 62 };
        quickSort(input, 0, input.length-1 );
        System.out.println("sorted array got is " + input);

    }

    /**
     * This will call itself recursivley untill array is sort
     *
     * @param array
     * @param start
     * @param end
     */

    public static void quickSort(int[] array, int start, int end) {
        // here is algorithm.  Parition the array on pivot and recursively call quick sort. return wall

        if (start < end) {

        int wall = partition(array, start, end);
        quickSort(array, start , wall-1);
        quickSort(array, wall+1 , end);
        }

    }


    static int partition(int[] array, int start, int end ){

        int pivot = array[end];
        int wall = start;
        for ( int counter=start; counter < end; counter++ ) {
            if( array[counter] < pivot){
                // swap it with first element after wall and increament wall
                swap(array, counter, wall);
                // increament wall
                wall = wall+1;
            }



        }

        //now drop the pivot at wall

        swap(array, wall, end);

        return wall;
    }

    private static void swap(int []array, int index1, int index2 ) {

        int buffer= array[index1];
        array[index1] = array[index2];
        array[index2] = buffer;

    }
}