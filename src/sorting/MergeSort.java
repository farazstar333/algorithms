package sorting;

/**
 * Created by farazw808 on 12/10/14.
 * write algorithm to simulate merge sort
 * given an array do merge sort.
 * here is algorithm. divide the array into half and repeat.
 */
public class MergeSort {

    public static void main(String args[]) {

        int[] list = {12, 34, 67, 80, 40, 4, 10, 22, 45, 70, 8, 56, 40, 14, 42, 66};

        int[] sortedArray = sort(list, 0, list.length);

        System.out.println(sortedArray);

    }


    private static int[] sort(int[] list, int start, int end) {

        int mid = (list.length / 2);
        if (mid >= 2) {
            int[] left = sort(list, start, mid);
            int[] right = sort(list, mid, list.length);
            // when all sorting is done, start merging.
            return list = merge(left, right);
        } else { // it means it is base case where there is is only one element.
            int[] mergeArray = new int[1]; mergeArray[0]= list[end]; // end =start
            return mergeArray;
        }


    }


    private static int[] merge(int left[], int right[]) {

        // create a new array of size left + right
        int[] mergeArray = new int[left.length + right.length];
        int leftIndex = 0, rightIndex = 0;

        //now compare elements of left and right array and move them in deltaArray
        for (int mergeIndex = 0; mergeIndex < mergeArray.length; mergeIndex++) {
            if (left[leftIndex] <= right[rightIndex] && leftIndex < left.length) {
                mergeArray[mergeIndex] = left[leftIndex];
                leftIndex++;
            } else if (rightIndex < right.length) {
                mergeArray[mergeIndex] = right[rightIndex];
                rightIndex++;
            }

        }

        return mergeArray;
    }
}
