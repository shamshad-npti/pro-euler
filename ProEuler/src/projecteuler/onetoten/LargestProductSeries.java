package projecteuler.onetoten;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author shame
 */
public class LargestProductSeries {
    public static long solve() throws FileNotFoundException {
        Scanner in = new Scanner(new File("1000-d-number"));
        StringBuilder buffer = new StringBuilder();
        while(in.hasNextLine())
            buffer.append(in.nextLine());
        long p = 1, max = 0;
        int i = 0;
        int j = -1; // there is a zero at -1
        while(i < 1000) {
            int d1 = buffer.charAt(i) - '0';
            if(d1 == 0) {
                j = i;
                p = 1;
            } else {
                p *= d1;
                if(i - j >= 13) {
                    int d2 = i - j > 13 ? buffer.charAt(i - 13) - '0' : 1;
                    p /= d2;
                    max = Math.max(p, max);
                }                
            }
            i++;
        }
        return max;
    }
}
