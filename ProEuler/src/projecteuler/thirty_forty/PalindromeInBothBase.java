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
public class PalindromeInBothBase {
    public static int solve() {
        int ans = 0, max = 1000_000_00, p, i = 1;
        while ((p = makePalindrome(i++, true)) < max) {
            if (isPalin(p, 10)) {
                ans += p;
            }
        }
        i = 1;
        while ((p = makePalindrome(i++, false)) < max) {
            if (isPalin(p, 10)) {
                ans += p;
            }
        }
        return ans;
    }

    private static boolean isPalin(int k, int b) {
        int r = 0, n = k;
        while (k != 0) {
            r = r * b + k % b;
            k /= b;
        }
        return r == n;
    }

    private static int makePalindrome(int i, boolean odd) {
        int j = odd ? i >> 1 : i;
        while (i > 0) {
            j = (j << 1) | ((i & 1));
            i >>= 1;
        }
        return j;
    }
}
