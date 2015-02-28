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
package projecteuler.thirty_forty;

/**
 *
 * @author shame
 */
public class IntegerRightTriang {
    public static int solve() {
        int[] max = new int[1000];
        int t = 0;
        for (int c = 499; c > 1; c--) {
            for (int b = c - 1; c < 1.5 * b; b--) {
                double d = Math.sqrt((c - b) * (c + b));
                int a = (int) d;
                if (a == d && a < b && a + b + c < 1000) {
                    max[a + b + c]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 1000; i++) {
            if (max[0] < max[i]) {
                ans = i;
                max[0] = max[i];
            }
        }
        return ans;
    }
}
