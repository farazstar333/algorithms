package sorting;

/**
 * Created by farazw808 on 12/10/14.
 * write algorithm to simulate merge sort
 * given an array do merge sort.
 * here is algorithm. divide the array into half and repeat.
 */
public class MergeSort {



    public static void main(String args[]) {

        int[] list = {34, 12, 67, 80, 55, 32, 10, 5, 45, 20, 60, 22};

        mergeSort(list);

        System.out.println(list);

    }


    private static void mergeSort(int[] list) {

        if (list.length > 1) { // base case

            int mid = (int) list.length / 2; // round off to closest
            // use list copy to create new list
            int[] left = new int[mid];
            System.arraycopy(list, 0, left, 0, mid);
            mergeSort(left);
            // now copy right sub-array
            int[] right = new int[list.length - mid];
            System.arraycopy(list, mid, right, 0, list.length - mid);
            mergeSort(right);

            // now merge the two sub-array into parent array
            merge(list, left, right);


        }


    }


    private static void merge(int[] list, int[] left, int[] right) {

        // now merge left and right sub-array into parent one
        // pointers for left and right positions
        int leftIndex = 0;
        int rightIndex = 0;

        for (int counter = 0; counter < list.length; counter++) {

            if (rightIndex >= right.length) {
                // it means we are done with right array and just copy left into parent
                list[counter] = left[leftIndex++];
            }
            else if (leftIndex >= left.length) { // it means we are done with left array and just copy right array into parent
                list[counter] = right[rightIndex++];
            }
            else if (left[leftIndex] <= right[rightIndex]) { // if left is smaller than right
                list[counter] = left[leftIndex++];

            }
            else {
                list[counter] = right[rightIndex++];

            }

        }


    }


}
