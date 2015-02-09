package projecteuler.onetoten;

/**
 *
 * @author shame
 */
public class SpecialTriplet {
    public static int solve() {
        for(int c = 499; c >= 333; c--) {
            int b = c  - 1, a = 1000 - (b + c);
            for(; b > a; b--, a++)
                if(a * a + b * b == c * c)
                    return a * b * c;
        }
        return 0;
    }
}
