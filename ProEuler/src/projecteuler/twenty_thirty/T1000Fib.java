package projecteuler.twenty_thirty;

import java.math.BigInteger;

/**
 *
 * @author shame
 */
public class T1000Fib {
    public static int solve() {
        BigInteger f1 = BigInteger.ONE, f2 = BigInteger.ONE, f3;
        int c = 2;
        while(f2.toString().length() < 1000) {
            f3 = f1.add(f2);
            f1 = f2;
            f2 = f3;
            c++;
        }
        return c;
    }
}
