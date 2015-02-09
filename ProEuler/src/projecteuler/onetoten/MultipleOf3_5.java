package projecteuler.onetoten;

/**
 *
 * @author Shamshad Alam
 */
public class MultipleOf3_5 {
    public static int solve() {
        int th = 1000 / 3;
        int fv = 1000 / 5 - 1;
        int ft = 1000 / 15;
        return 3 * th * (th + 1) / 2 
                + 5 * fv * (fv + 1) / 2 
                - 15 * ft * (ft + 1) / 2;
    }
}
