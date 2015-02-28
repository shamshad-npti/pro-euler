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

import java.util.Iterator;
import projecteuler.PrimeUtils;

/**
 *
 * @author Shamshad Alam
 */
public class GoldBachConj {
    public static int solve() {
        for (int i = 5;; i += 2) {
            if (PrimeUtils.isPrime(i)) {
                continue;
            }
            boolean flag = true;
            outer:
            for (int j = 1; 2 * j * j < i; j++) {
                Iterator<Integer> itr = PrimeUtils.primeIterator(3);
                int k;
                while (itr.hasNext() && (k = itr.next() + 2 * j * j) <= i) {
                    if (k == i) {
                        flag = false;
                        break outer;
                    }
                }
            }
            if (flag) {
                return i;
            }
        }
    }
}
