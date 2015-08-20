package sorting;

/**
 * Created by farazw808 on 8/19/15.
 * A simple algorithm for bubble sort
 */
public class BubbleSort {

    public static void main(String args[]) {

        // bubble sort an array like { 5, 7,20, 9, 2, 22, 45, 100, 40, 30, 78, 12, 100, 14, 62 }

        int  input[] = { 5, 7,20, 9, 2, 22, 45, 100, 40, 30, 78, 12, 100, 14, 62 };
        bubble(input);
        System.out.println("sorted array got is " + input);

    }

    public static void bubble( int args[]) {

        // sort input array

        for (int x=0; x< args.length; x++) {

            for(int y=x+1; y < args.length; y++) {

                // swap x and y in case x is smaller than y
                if( args[x]  >= args[y]) swap(x,y, args);


            }
        }


    }

   private static void swap(int index1, int index2, int args[])  {

       int buffer=args[index1];
       args[index1] = args[index2];
       args[index2] = buffer;
   }

}
