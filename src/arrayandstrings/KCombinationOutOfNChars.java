package arrayandstrings;

/**
 * Created by farazw808 on 7/26/15.
 * <p>
 * This program calculates k length string out of possible character set of n without repititions.
 * <p>
 * For example find all 3 letter string (abc) for example out of 5 characters {a, b, c, d, e}
 * <p>
 * We can also find al possible combination for example of 8 characters from alphabet set {a-z}
 * <p>
 * There are two problems here.  First find all way we can create 3 letter string out of 6 in which order does not matter.
 * Then we will create all permutations of each 3 letter string. For example in above example
 * 6*5*4*6
 */
public class KCombinationOutOfNChars {

    static int  k = 3; // k is size of length of word
    static int wordCounter=0;

    /**
     * print all permutations of given string.
     * For example for abc we have
     * abcdef
     * bac
     * cba etc
     * There are two parts of problems. First find all combinations where orders does not matter of k letter words from n size alphabets sets.
     * We will use sliding windows to find it. for each work we will find
     *
     * @param permutedAndCombSource is input string and output is desired output of k characters.
     *                              index is where we stand in permuted string and it points to string remain to be processed.
     */
    public static void printAllCombinationAndPermutation(String permutedAndCombSource, int index) {

        // base condition if output size is 3 it means we are done with our size k and just print string
        // no more need of window sliding
        if (permutedAndCombSource.length() - (index + k) <= 0) // if we already reached at word length and it is base condition of recursion and just print permutation of string in question
        {   printAllPermutation(permutedAndCombSource.toCharArray(), 0); return; }

        for (int count = index; count+k < permutedAndCombSource.length(); count++) {
            //keep cahr at index constant and slide window from
            // extract k char combinations from input string in sliding window and print each permutation
           char start = permutedAndCombSource.charAt(index);
            printAllPermutation(( start + permutedAndCombSource.substring(count+1,count+k ) ).toCharArray(), 0);


        }

        printAllCombinationAndPermutation(permutedAndCombSource, index + 1);

    }


    public static void printAllPermutation(char[] permutedSource, int index) {

        // base condition if output size is 3 it means we are done with our size k and just print string

        if (index == permutedSource.length - 1)
        {   System.out.println(permutedSource);
            wordCounter++;
        }

        // we will first try to swap position         for( int count=0; count < permutedSource.length(); count ++) {

        for (int count = index; count < permutedSource.length; count++) {

            char[] permString = swap(permutedSource, index, count);
            printAllPermutation(permString, index + 1); // calls itself recursively to start with next chat in string

        }


    }


    public static char[] swap(char[] source, int n, int m) {

        char temp = source[n];
        source[n] = source[m];
        source[m] = temp;
        return source.clone();


    }

    public static void main (String args[]) {


        String input = "abc";

        // now print all permutation. should be 3*2*1= 6

        KCombinationOutOfNChars.printAllCombinationAndPermutation("abcdef", 0);
        System.out.println("total combination/counters find are " + wordCounter);


    }


}
