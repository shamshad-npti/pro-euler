package projecteuler.onetoten;

import java.util.Iterator;
import projecteuler.PrimeUtils;

/**
 *
 * @author shame
 */
public class SummationOfPrimes {
    public static long solve() {
        Iterator<Integer> itr = PrimeUtils.primeIterator();
        long sum = 0;
        int p = itr.next();
        while(p < 2000000) {
            sum += p;
            p = itr.next();
        }
        return sum;
    }
}
