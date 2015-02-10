package projecteuler.twenty_thirty;

import java.util.Arrays;

/**
 *
 * @author shame
 */
public class DistinctPower {
    public static int solve() {
        int ans = 9801;
        ans = ans - 49 * 9; // square removed
        ans = ans - 32 * 3 + 1; // cube removed except 2 ^ 6 = 4 ^ 3 (dual remove)
        ans = ans - 24 * 2; // forth removed
        ans = ans - 19; // fifth power
        ans = ans - 15; // sixth power
        return ans;
    }
}
