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

import java.util.Iterator;
import projecteuler.PrimeUtils;

/**
 *
 * @author Shamshad Alam
 */
public class PrimeSum {
    public static int solve() {
        int s = 100, ans = Integer.MAX_VALUE, j = 0, k;
        int[] dp = new int[s + 1];
        dp[0] = 1;
        Iterator<Integer> itr = PrimeUtils.primeIterator();
        while (itr.hasNext() && j <= s) {
            for (j = itr.next(), k = j; k < s; k++) {
                dp[k] += dp[k - j];
                if (dp[k] > 5000) {
                    ans = Math.min(ans, k);
                }
            }
        }
        return ans;
    }
}
