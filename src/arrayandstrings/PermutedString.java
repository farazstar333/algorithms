package arrayandstrings;

/**
 * Created by farazw808 on 10/29/14.
 * Given two strings. tell if one string is permutation of other.
 * string are permutation is one string can be derived from other using changing character positions only (no addition o subtraction)
 * like faraz and zaraf are permutation of each other but faraz and zarf are not
 */
public class PermutedString {

    String  input1 = "faraz";
    String input2 = "zaarf";
    String  input3 = "zarf";


    boolean ifPermutation (String input1, String input2){

        // condition 1 . If input1 and input 2 are different length then they are not permutation.
        if (input1.length() != input2.length())  return false;

        // condition2, do count for each char for one string. Now using that hash table look
        // other way i

        // other way is to sort both arrays and then compare sorted strings.

        return true;

    }

}
