package projecteuler.twenty_thirty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author shame
 */
public class TriangleSum {
    public static int solve() throws FileNotFoundException {
        Scanner in = new Scanner(new File("triangle"));
        int s = 15;
        int[][] n = new int[s][];
        for(int i = 0; i < s; i++) {
            n[i] = new int[i + 2];
            for(int j = 0; j <= i; j++)
                n[i][j] = in.nextInt();
        }
        for(int i = s - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++)
                n[i][j] = n[i][j] + Math.max(n[i + 1][j], n[i + 1][j + 1]);
        }
        return n[0][0];
    }
}
