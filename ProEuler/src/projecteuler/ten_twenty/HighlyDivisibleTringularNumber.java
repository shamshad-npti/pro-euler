package projecteuler.ten_twenty;

import java.util.Iterator;
import projecteuler.PrimeUtils;

/**
 *
 * @author shame
 */
public class HighlyDivisibleTringularNumber {
    public static int solve() {
        int start = 10;
        while(true) {
            if(!PrimeUtils.isPrime(start)) {
                int s = start * (start + 1) / 2;
                int p = 1;
                Iterator<Integer> itr = PrimeUtils.primeIterator(2);
                while(s != 1) {
                    int k = itr.next(), r = 0;
                    if(s % k == 0) {
                        while(s % k == 0) {
                            r++;
                            s /= k;
                        }
                        p *= (r + 1);
                    }
                }
                if(p > 500) return start * (start + 1) / 2;
            }
            start++;
        }
    }
}
