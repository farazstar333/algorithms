package misc;

/**
 * Created by farazw808 on 7/3/15.
 */
public class SquareRoot {

    /**
     * use babylonian formula to compute square root.
     *
     * @param number
     * @return
     */
    static double squareRoot(double number) {

        //take a guess. easier just to make it as number
        double guess = number;
        double error = .01;

        while ((guess - number / guess) > error) {

            guess = (guess + number / guess) / 2;
        }

        return guess;

    }

    public static void main(String args[]) {

        System.out.println("square root of number 25 is " + squareRoot(25));
        System.out.println("square root of number 40 is " + squareRoot(40));
        System.out.println("square root of number 35 is " + squareRoot(35));
        System.out.println("square root of number 27 is " + squareRoot(27));
        System.out.println("square root of number 80 is " + squareRoot(80));
        System.out.println("square root of number 81 is " + squareRoot(81));

    }
}
