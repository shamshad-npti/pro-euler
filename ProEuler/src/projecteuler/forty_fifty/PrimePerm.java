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
package projecteuler.forty_fifty;

import projecteuler.PrimeUtils;

/**
 *
 * @author Shamshad Alam
 */
public class PrimePerm {
    public static long solve() {
        for (int i = 1489; i <= 33340; i += 2) {
            if (PrimeUtils.isPrime(i) && PrimeUtils.isPrime(i + 3330) && isPerm(i, i + 3330)
                    && PrimeUtils.isPrime(i + 6660) && isPerm(i, i + 6660)) {
                return 1l * i * 100000000 + (i + 3330) * 10000 + i + 6660;
            }
        }
        return -1; // Unexpected
    }

    private static boolean isPerm(int i, int j) {
        int[] d = new int[10];
        int r1, r2;
        while (i != 0) {
            r1 = i % 10;
            r2 = j % 10;
            i /= 10;
            j /= 10;
            d[r1]++;
            d[r2]--;
        }
        for (int e : d) {
            if (e != 0) {
                return false;
            }
        }
        return true;
    }
}
