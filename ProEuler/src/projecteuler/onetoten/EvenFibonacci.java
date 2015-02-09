package projecteuler.onetoten;

/**
 *
 * @author shame
 */
public class EvenFibonacci {
    public static int solve() {
        int f1 = 1, f2 = 2, f3 = f1 + f2, sum = 0;
        while(f3 < 4000000) {
            if((f2 & 1) == 0)
                sum += f2;
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return sum;
    }
}
