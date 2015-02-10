package projecteuler.twenty_thirty;

/**
 *
 * @author shame
 */
public class SpiralSum {
    public static int solve() {
        int s = 2, ans = 1, cur, end = 1, k = 1;
        while(k < 1001) {
            cur = end + s;
            end = cur + 3 * s;
            s+= 2;
            ans += 2 * (cur + end);
            k += 2;
        }
        return ans;
    }
}
