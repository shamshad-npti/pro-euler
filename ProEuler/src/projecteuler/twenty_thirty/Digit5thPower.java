package projecteuler.twenty_thirty;

/**
 *
 * @author shame
 */
public class Digit5thPower {
    public static int solve() {
        int ans = 0, start = 10, end = 9 * 9 * 9 * 9 * 9 * 5;
        int[] b = {0, 1, 32, 243, 1024, 3125, 7776, 16807, 32768, 59049};
        
        while(start < end) {
            int sum = 0, n = start;
            while(n != 0) {
                sum += b[n % 10];
                n /= 10;
            }
            if(sum == start) 
                ans += start;
            start++;
        }
        return ans;
    }
}
