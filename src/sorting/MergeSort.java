package sorting;

/**
 * Created by farazw808 on 12/10/14.
 * write algorithm to simulate merge sort
 * given an array do merge sort.
 * here is algorithm. divide the array into half and repeat.
 */
public class MergeSort {

    static int depth=0;

    public static void main(String args[]) {

        int[] list = {34, 12, 67, 80};

        int[] sortedArray = sort(list, 0, list.length - 1, list.length);

        System.out.println(sortedArray);

    }


    private static int[] sort(int[] list, int start, int end, int size) {


        if (size >= 2) {
            int mid = (size / 2);
            { //in case mid is even.
                System.out.println("left side: start= " + start + " mid = " +  mid + " end= " +  end  + " size= " + size);

                int[] left = sort(list, start, mid - 1, size / 2);

                System.out.println("right side: start= " + start + " mid = " +  mid + " end= " +  end  + " size= " + size);
                int[] right = sort(list, mid, end, size / 2);
                // when all breaking is done, start merging.
                return merge(left, right);
            }
        }

        else { // it means it is base case where there is is only one element.
            int[] mergeArray = new int[1];
            if(end == start)  // end =start
            mergeArray[0] = list[start];
            else
            System.out.println("error condition");
            return mergeArray;
        }


    }


    private static int[] merge(int left[], int right[]) {

        // create a new array of size left + right
        int[] mergeArray = new int[left.length + right.length];
        int leftIndex = 0, rightIndex = 0;

        //now compare elements of left and right array and move them in deltaArray
        for (int mergeIndex = 0; mergeIndex < mergeArray.length; mergeIndex++) {

            if (rightIndex >= right.length) // it means right side is empty and just use left array
                mergeArray[mergeIndex] = left[leftIndex++];
            else if (leftIndex >= left.length)
                mergeArray[mergeIndex] = right[rightIndex++];
            else if (left[leftIndex] <= right[rightIndex])
                mergeArray[mergeIndex] = left[leftIndex++];
            else
                mergeArray[mergeIndex] = right[rightIndex++];
        }

        return mergeArray;
    }
}
