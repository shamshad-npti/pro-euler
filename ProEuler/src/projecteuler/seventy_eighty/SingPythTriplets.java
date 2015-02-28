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
package projecteuler.seventy_eighty;

/**
 *
 * @author Shamshad Alam
 */
public class SingPythTriplets {
    public static int solve() {
        int ans = 0, s = 1_500_000, m, n, a, b, c, k, j;
        int mx = (int) Math.sqrt(s);
        int[] dp = new int[s + 1];
        for (m = 2; m < mx; m++) {
            for (n = (m & 1) == 0 ? 1 : 2; n < m; n += 2) {
                if (gcd(m, n) == 1) {
                    a = m * m - n * n;
                    b = 2 * m * n;
                    c = m * m + n * n;
                    j = k = a + b + c;
                    while (j <= s) {
                        dp[j]++;
                        j = j + k;
                    }
                }
            }
        }
        for (int e : dp) {
            if (e == 1) {
                ans++;
            }
        }
        return ans;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
