package projecteuler.ten_twenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author shame
 */
public class LargestProductInGrid {
    private static final int[]dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    private static final int[]dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    public static int solve() throws FileNotFoundException {
        Scanner in = new Scanner(new File("20x20-number"));
        int s = 20;
        int[][] num = new int[s][s];
        for (int i = 0; i < s; i++) 
            for (int j = 0; j < s; j++)
                num[i][j] = in.nextInt();
        int max = 0, rp = 1, cp = 1;
        for(int i = 0; i < 16; i++) {
            rp = cp = 1;
            for(int j = i; j < i + 4; j++) {
                rp *= num[i][j];
                cp *= num[j][i];
            }
            max = Math.max(cp, Math.max(max, rp));
        }
        int d1, d2;
        s = s - 1;
        for(int i = 3; i < 20; i++) {
            for(int k = i, j = 0; k >= 3; k--, j++) {
                d1 = d2 = rp = cp = 1;
                for(int x = k, y = j; x >= k - 3; x--, y++) {
                    d1 *= num[y][x];
                    d2 *= num[s - y][x];
                    cp *= num[s - y][s - x];
                    rp *= num[y][s - x];
                }
                max = Math.max(max, Math.max(Math.max(rp, cp), Math.max(d1, d2)));
            }
        }
        return max;
    }
}
