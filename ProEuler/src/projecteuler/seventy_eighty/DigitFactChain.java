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

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Shamshad Alam
 */
public class DigitFactChain {
    private final static int[] fact = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    public static int solve() {
        int ans = 0, k;
        for (int i = 1; i <= 1000000; i++) {
            Set<Integer> sets = new HashSet<>(60);
            k = i;
            sets.add(k);
            while (!sets.contains((k = sum(k)))) {
                sets.add(k);
            }
            if (sets.size() == 60) {
                ans++;
            }
        }
        return ans;
    }

    private static int sum(int d) {
        int ans = 0;
        while (d != 0) {
            ans += fact[d % 10];
            d /= 10;
        }
        return ans;
    }
}
