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
 * @author Shamshad Alam
 */
public class DigitFactEq {
    public static int solve() {
        int ans = 0;
        int[] fact = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        for (int i = 11; i < fact[9] * 7; i++) {
            int k = i, s = 0;
            while (k != 0) {
                s += fact[k % 10];
                k /= 10;
            }
            if (i == s) {
                ans += s;
                System.out.println(i);
            }
        }
        return ans;
    }
}
