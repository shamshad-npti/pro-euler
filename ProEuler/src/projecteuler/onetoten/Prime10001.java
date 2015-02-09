package projecteuler.onetoten;

import java.util.Iterator;
import projecteuler.PrimeUtils;

/**
 *
 * @author shame
 */
public class Prime10001 {
    public static int solve() {
        int k = 0, p = 0;
        Iterator<Integer> itr = PrimeUtils.primeIterator(2);
        while(k < 10001) {
            p = itr.next();
            k++;
        }
        return p;
    }
}
