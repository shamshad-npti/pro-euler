package projecteuler.twenty_thirty;

import java.math.BigInteger;

/**
 *
 * @author shame
 */
public class FactDigitSum {
    public static int solve() {
        BigInteger fact = BigInteger.ONE;
        for(int i = 2; i <= 100; i++)
            fact = fact.multiply(BigInteger.valueOf(i));
        String num = fact.toString();
        int ans = 0;
        for(int i = 0; i < num.length() - 24; i++)
            ans += num.charAt(i) - '0';
        return ans;
    }
}
