package projecteuler.twenty_thirty;

import java.util.Iterator;
import projecteuler.PrimeUtils;

/**
 *
 * @author shame
 */
public class Quadratic {
    public static int solve() {
        Iterator<Integer> itr = PrimeUtils.primeIterator(3);
        int size = -1;
        int[] pn = new int[1000];
        pn[++size] = 1;
        do {
            pn[++size] = itr.next();
        } while(pn[size] < 1000);
        
        int max = 0, ans = 0, tmp;
        for(int i = 0; i < size; i++) {
            for(int j = i; j < size; j++) {
                if((tmp = primeCount(pn[i], pn[j])) > max) {
                    max= tmp;
                    ans = pn[i] * pn[j];
                } else if((tmp = primeCount(-pn[i], pn[j])) > max) {
                    max = tmp;
                    ans = -pn[i] * pn[j];
                }
            }
        }
        return ans;
    }
    
    private static int primeCount(int a, int b) {
        for(int i = 0; ; i++) {
            int n = i * (i + a) + b;
            if(n < 0 || !PrimeUtils.isPrime(n))
                return i;
        }
    }
}
