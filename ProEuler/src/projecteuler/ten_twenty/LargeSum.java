package projecteuler.ten_twenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author shame
 */
public class LargeSum {
    public static String solve() throws FileNotFoundException {
        int s = 100, l = 12;
        String num;
        int[] sum = new int[55];
        Scanner in = new Scanner(new File("50-digit-num"));
        for(int i = 0; i < s; i++) {
            num = in.nextLine();
            int c = 0, a;
            for(int k = l - 1; k >= 0; k--) {
                a = sum[k + 1] + c + num.charAt(k) - '0';
                sum[k + 1] = a % 10;
                c = a / 10;
            }
            sum[0] += c;
        }
        StringBuilder buffer = new StringBuilder();
        for(int i = 0; i <= l; i++)
            buffer.append(sum[i]);
        return buffer.substring(0, 10);
    }
}
