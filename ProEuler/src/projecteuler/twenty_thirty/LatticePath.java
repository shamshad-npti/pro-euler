package projecteuler.twenty_thirty;

/**
 *
 * @author shame
 */
public class LatticePath {
    public static long solve() {
        //return ncr(); // (2 * n) ! / (n !) ^ 2;
        // dp solution
        int s = 20;
        long[][] ans = new long[s + 1][s + 1];
        ans[1][0] = ans[0][1] = 1;
        for(int i = 0; i <= 20; i++)
            ans[i][0] = ans[0][i] = 1;
        for(int i = 1; i <= 20; i++) {
            for(int j = i; j <= 20; j++) {
                ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
                ans[j][i] = ans[j - 1][i] + ans[j][i - 1];
            }
        }
        return ans[20][20];
    }
    
    private static long ncr() {
        long n = 1, d = 1;
        for(int i = 40, j = 20; i > 20; i--, j--) {
            n *= i;
            d *= j;
            long p = gcd(n, d);
            if(p != 1) {
                n /= p;
                d /= p;
            }
        }   
        return n / d;
    }
    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
