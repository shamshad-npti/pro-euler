package projecteuler.ten_twenty;

import java.math.BigInteger;

/**
 *
 * @author shame
 */
public class DigitSum {
    public static int solve() {
        BigInteger b = new BigInteger("2");
        b = b.pow(1000);
        int s = 0;
        String n = b.toString();
        for (int i = 0; i < n.length(); i++) 
            s += (n.charAt(i) - '0');
        return s;
    }
}
