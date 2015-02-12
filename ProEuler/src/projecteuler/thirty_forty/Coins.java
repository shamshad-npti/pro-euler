package projecteuler.thirty_forty;

/**
 *
 * @author Shamshad Alam
 */
public class Coins {
    public static int solve() {
        int t = 202;
        int[] dp = new int[t];
        int[] cns = {1, 2, 5, 10, 20, 50, 100, 200};
        dp[0] = 1;
        for (int cn : cns) {
            for (int i = cn; i < t; i++)
                dp[i] += dp[i - cn];
        }
        return dp[200];
    }
}
