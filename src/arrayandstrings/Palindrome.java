package arrayandstrings;


/**
 * Created by farazw808 on 7/8/14.
 * Write a program to find if given string is palindrome or not.
 * palindrome is a string which if inverted remains same
 * The plain vanila way of using a buffer and start reading the string from end and appending at buffer.
 * If resulted string is same as original then it is PalinDrome. But that is not fun.
 * Fun is how we compare characters at n and 0, n-1 1 and so
 * O(n/2)
 */
public class Palindrome {


    /**
     * It will
     * @param input
     */
    public static boolean ifPalindrome(String input){

        int count= input.length();
        char[] stringArray = input.toCharArray();
        for(int n=0; n < count/2; n++){

            if(stringArray[n] != stringArray[count-n-1])
                return false;

        }

        return true;
    }


    public static void main(String args[]) {

        String input= "faraf";
        String input2 ="faraz";

        if (Palindrome.ifPalindrome(input))
            System.out.println("input " + input + " is palin");
        else
            System.out.println("input " + input + " is  not palin");

        if (Palindrome.ifPalindrome(input2))
            System.out.println("input " + input2 + " is palin");
        else
            System.out.println("input " + input2 + " is not palin");


    }





}
