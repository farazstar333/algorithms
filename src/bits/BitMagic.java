package bits;

/**
 * Created by farazw808 on 7/4/15.
 * This class contains different bit manipulation problems.
 */
public class BitMagic {

    /**
     * get ith bit from num.
     * Use mask like 00001000.
     * All we care is result should be other that zero.
     * @param num
     * @param i
     * @return
     */
    public boolean getBit(int num, int i) {

        // create a mask after doing left shifting bits to ith time something like 0---00000100
       // then do AND. if we get 1 back it means that bit is 1 otherwise 0
           return ( (num & 1<<i) != 0);



    }
        // we are turning on bit at ith position.
    public int setBit(int num, int i){
        // set bit at ith position  use 000001000
        return num | 1 <<i;

    }

    // toggle bit XOR it with 0000100000
    public int toggleBit(int num, int i) {
        return num ^ 1<<i;
    }

    // toggle bit XOR it with 0000100000
    public int clearBit(int num, int i) {

        // for clearing bit we need to AND given number with pattern like 111011111
        // we will start with number 00000001. shift it ith time and then negate it using xor
            return (num & (1<<i ^ 0) );
    }

    // explains what following code does. 11000010 if we subtract 1 from last position it will result in 0 or 1 depending upon if it is 0 and 1
    // it will be 0 if there is 1 at last position and 1 if there is 0 (it will take carry). in case 0
    // now if we AND it with same number n&n , it will return 0 or 1

}
