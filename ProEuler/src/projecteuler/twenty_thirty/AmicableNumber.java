package projecteuler.twenty_thirty;

import java.util.Iterator;
import projecteuler.PrimeUtils;

/**
 *
 * @author shame
 */
public class AmicableNumber {
    public static int solve() {
        int k = 2, ans = 0, t = 10000;
        int[] dp = new int[t];
        while(k < t) {
            if(!PrimeUtils.isPrime(k)) {
                Iterator<Integer> itr = PrimeUtils.primeIterator();
                int sum = 1, n = k;
                while(n != 1) {
                    int p = itr.next();
                    if(n % p == 0) {
                        int s = 1;
                        while(n % p == 0) {
                            n /= p;
                            s = s * p + 1;
                        }
                        sum *= s;
                    }
                }
                sum -= k;
                dp[k] = sum;
                if(sum < k && dp[sum] == k)
                    ans += k + sum;
            }
            k++;
        }
        return ans;
    }
}
