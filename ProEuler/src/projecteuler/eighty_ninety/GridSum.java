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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Shamshad Alam
 */
public class GridSum {
    public static long solve() throws FileNotFoundException {
        int s = 80;
        long[][] gr = new long[s + 1][s + 1];
        Scanner in = new Scanner(new File("p081_matrix.txt"));

        for (int i = 0; i < s; i++) {
            Scanner in1 = new Scanner(in.next().replace(',', ' '));
            for (int j = 0; j < s; j++) {
                gr[i][j] = in1.nextInt();
            }
        }
        for (int i = 1; i < s; i++) {
            gr[i][0] = gr[i][0] + gr[i - 1][0];
            gr[0][i] = gr[0][i] + gr[0][i - 1];
            for (int j = 1; j < i; j++) {
                gr[i][j] = gr[i][j] + Math.min(gr[i - 1][j], gr[i][j - 1]);
                gr[j][i] = gr[j][i] + Math.min(gr[j - 1][i], gr[j][i - 1]);
            }
            gr[i][i] = gr[i][i] + Math.min(gr[i - 1][i], gr[i][i - 1]);
        }
        return gr[79][79];
    }
}
