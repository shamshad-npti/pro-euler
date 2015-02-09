package projecteuler.onetoten;

/**
 *
 * @author shame
 */
public class LargestPalindromeProduct {
    public static int solve() {
        int s = 999;
        do {
            int p = palindrome(s);
            s--;
            int k = 999;
            while( p / k < 1000) {
                if(p % k == 0)
                    return p;
                k--;
            }
        } while(true);
    }
    
    private static int palindrome(int t) {
        return t * 1000 + (t % 10) * 100 + ((t / 10) % 10) * 10 + (t / 100);
    }
    
}
