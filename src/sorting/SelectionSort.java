package sorting;

/**
 * Created by farazw808 on 8/19/15.
 * in selection sort we select lowest element one at time by scaning through list
 * selection sort is better than bubble sort as it uses less comparasions.
 */
public class SelectionSort {

    public static void main(String args[]) {

        // bubble sort an array like { 5, 7,20, 9, 2, 22, 45, 100, 40, 30, 78, 12, 100, 14, 62 }

        int  input[] = { 5, 7,20, 9, 2, 22, 45, 100, 40, 30, 78, 12, 100, 14, 62 };
        select(input);
        System.out.println("sorted array got is " + input);

    }
    public static void select( int args[]) {

        // sort input array


        // let assume that
        for (int x=0; x< args.length; x++) {

            int min =args[x];
            int minIndex=x;

            for(int y=x+1; y < args.length; y++) {

             // scan via whole array and select min index
            if ( args[y] < min) {
                min=args[y];
                minIndex=y;
            }


            }
            // now swap min index and x
            swap(minIndex, x, args);

        }


    }

    private static void swap(int index1, int index2, int args[])  {

        int buffer=args[index1];
        args[index1] = args[index2];
        args[index2] = buffer;
    }

}
