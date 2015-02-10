package projecteuler.twenty_thirty;

import java.util.Iterator;
import projecteuler.PrimeUtils;

/**
 *
 * @author shame
 */
public class LongestRecFrac {
    public static int solve() {
        int cur = 3, ans = cur, max = 0;
        while(cur < 100000) {
            boolean[] b = new boolean[cur];
            int k = 1, cnt = 0;
            while(!b[k]) {
                b[k] = true;
                cnt++;
                k *= 10;
                k %= cur;                
            }
            
            if(cnt > max) {
                ans = cur;
                max = cnt;
            }
            
            cur += 2;
        }
        return ans;
    }
}
