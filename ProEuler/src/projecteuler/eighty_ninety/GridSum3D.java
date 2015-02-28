/*
 * Copyright (C) 2015 Shamshad Alam
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package projecteuler.eighty_ninety;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Shamshad Alam
 */
public class GridSum3D {
    public static int solve() throws FileNotFoundException {
        int s = 80;
        int[][] grid = new int[s + 1][s + 1];
        int ans = Integer.MAX_VALUE;
        Scanner in = new Scanner(new File("p083_matrix.txt"));

        for (int i = 0; i < s; i++) {
            Scanner in1 = new Scanner(in.next().replace(',', ' '));
            for (int j = 0; j < s; j++) {
                grid[i][j] = in1.nextInt();
            }
        }
        int[][] mat = new int[s][s];
        best = grid[0][0];
        for (int i = 0; i < s; i++) {
            Arrays.fill(mat[i], Integer.MAX_VALUE);
        }
        int j = 1, k = 1;
        while (!isOut(k, j)) {
            if (grid[j - 1][k] < grid[j][k - 1]) {
                best += grid[j - 1][k];
                k++;
            } else {
                best += grid[j][k - 1];
                j++;
            }
        }
        mat[0][0] = grid[0][0];
        System.out.println(best);
        long t = System.currentTimeMillis();
        solve(grid, mat, 0, 0);
        System.out.println(System.currentTimeMillis() - t);
        return mat[79][79];
    }

    public static int best = Integer.MAX_VALUE;

    private static void solve(int[][] grid, int[][] mat, int r, int c) {
        if (!isOut(r, c) && best > mat[r][c]) {
            int e = mat[r][c];

            if (r == 79 && c == 79) {
                best = Math.min(best, e);
            }

            int rr, cc;
            TreeMap<Point, Point> map = new TreeMap<>((p1, p2) -> p1.x == p2.x ? p1.y - p2.y : p1.x - p2.x);
            for (int i = 0; i < 4; i++) {
                rr = r + dd[i][0];
                cc = c + dd[i][1];
                int sum;
                if (!isOut(rr, cc) && (sum = grid[rr][cc] + e) < mat[rr][cc] && sum < best) {
                    map.put(new Point(grid[rr][cc], i), new Point(rr, cc));
                }
            }

            while (!map.isEmpty()) {
                Map.Entry<Point, Point> p = map.firstEntry();
                map.remove(p.getKey());
                rr = p.getValue().x;
                cc = p.getValue().y;
                if (grid[rr][cc] + mat[r][c] < mat[rr][cc]) {
                    mat[rr][cc] = grid[rr][cc] + mat[r][c];
                    solve(grid, mat, rr, cc);
                }
            }
        }
    }

    private static int[][] dd = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    private static boolean isOut(int i, int j) {
        return i < 0 || j < 0 || i > 79 || j > 79;
    }
}
