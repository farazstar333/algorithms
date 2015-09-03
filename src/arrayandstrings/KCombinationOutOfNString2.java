package arrayandstrings;

/**
 * Created by farazw808 on 8/30/15.
 */
public class KCombinationOutOfNString2 {

    static int wordCounter = 0;

    public static void main(String args[]) {


        String input = "abcdef";

        // now print all permutation. should be 3*2*1= 6
        printPermutation("abcd".toCharArray(), 0);
        KCombinationOutOfNString2.printAllCombinationAndPermutation("abcdef", 3);
        System.out.println("total combination/counters find are " + wordCounter);


    }


    public static void printAllCombinationAndPermutation(String input, int digit) {

        // if digit is > input.size it is error.  If it is equal to input.size, this is same case as all permutation of given string.
        if (digit == input.length()) printPermutation(input.toCharArray(), 0);

        for (int counter = 0; counter < input.length(); counter++) {

            printAllCombinationAndPermutation(createSubString(input, counter), digit);

        }

    }

    private static String createSubString(String input, int removeIndex) {

        if(removeIndex == 0) return  input.substring(1);
        if(removeIndex == input.length()-1) return input.substring(0, input.length()-2);

        String str1 = input.substring(0, removeIndex-1);
        String str2 = input.substring(removeIndex + 1, input.length()-1);

        return str1.concat(str2).trim();



    }

    public static void printPermutation(char strArr[], int cursor) {

        //this is how we compute all permutation of string. Think of input as "abc". we will exchange a with a b and c.
        // then we will recursivley call the method itself with rest of string. once we have string of length 1 it means we
        // are all done.
        if (strArr.length - cursor == 1) // we have string of length 1 abc.length =3 if we are index 2 it means we are done
        {
            System.out.println(strArr);  // base case
            wordCounter++;
        }

        for (int counter = cursor; counter < strArr.length; counter++) {

            printPermutation(swap(strArr, cursor, counter), cursor + 1);

        }


    }


    private static char[] swap(char strArr[], int i, int j) {

        char[] clone = strArr.clone();

        char temp = clone[i];
        clone[i] = clone[j];
        clone[j] = temp;

        return clone;


    }


}
