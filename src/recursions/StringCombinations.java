package recursions;

/**
 * Created by farazw808 on 7/9/15.
 * Find  all 3 letter combinations from array of string. (repeatitions not allowed)
 *
 * example given array { a b c d} find all 4 letter combinations and three letter combinations
 */
public class StringCombinations {


    /**
     * simpler version. here for 3 letter string, we will print combinations of 4 letters.
     * Think of it 4 letter number system with 3 raise 4 possible combinations i.e 256
     * @param input
     * @param index
     */
    public void printAllCharsCombinations(String input, int index) {

        // base case. in case counter=1 it measn we are at base case and we will just print the string.
        if(  index == 1)
            System.out.println(input);

        else {

            //iterate through rest of positions
            for(int count= 0; count < input.length(); count++){


            }

        }




    }



}
