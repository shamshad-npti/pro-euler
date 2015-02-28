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
public class DistPrimeFact {
    public static int solve() {
        int f = 646, d = 0;
        for (int i = f;; i++) {
            int n = i, k = 0;
            Iterator<Integer> itr = PrimeUtils.primeIterator();
            while (n != 1) {
                int r = itr.next();
                if (n % r == 0) {
                    k++;
                    while (n % r == 0) {
                        n /= r;
                    }
                    if (PrimeUtils.isPrime(n)) {
                        k++;
                        break;
                    }
                }
            }

            if (k == 4) {
                if (d == 0) {
                    f = i;
                } else if (d == 3) {
                    return f;
                }
                d++;
            } else {
                d = 0;
            }
        }
    }
}
