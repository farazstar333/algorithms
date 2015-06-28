import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by farazw808 on 6/24/15.
 * This shows an example of using lmbadas to sort an array.
 */
public class SortByLambadas {

    public static void main(String args[]){



        String list[] = {"Faraz", "Waseem", "Yoda", "Peter", "Pan", "Jedi", "Luke"};

        System.out.println(list.toString());

        Arrays.sort(list, (String first, String second) ->  Integer.compare(first.length(), second.length()));

        System.out.println(list.toString());


    }


}
