package projecteuler.onetoten;

import java.util.Iterator;
import projecteuler.PrimeUtils;

/**
 *
 * @author shame
 */
public class LargestPrimeFactor {
    public static int solve() {
        long n = 600851475143L;
        int p, ans = 0;
        Iterator<Integer> itr = PrimeUtils.primeIterator(3);
        while(n > 1) {
            p = itr.next();
            if(n % p == 0) {
                ans = p;
                while(n % p == 0)
                    n /= p;
            }
        }
        return ans;
    }
}
