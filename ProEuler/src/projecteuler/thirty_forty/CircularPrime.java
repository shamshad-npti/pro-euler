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

import java.util.Iterator;
import projecteuler.PrimeUtils;

/**
 *
 * @author shame
 */
public class CircularPrime {
    public static int solve() {
        int ans = 13, p;
        Iterator<Integer> itr = PrimeUtils.primeIterator(100);
        while ((p = itr.next()) < 1000_000) {
            int k = 1, t = p;
            while (t != 0) {
                t /= 10;
                k *= 10;
            }
            k /= 10;
            t = p;
            do {
                t = (t % k) * 10 + (t / k);
            } while (p != t && PrimeUtils.isPrime(t));
            if (t == p) {
                ans++;
            }
        }
        return ans;
    }
}
