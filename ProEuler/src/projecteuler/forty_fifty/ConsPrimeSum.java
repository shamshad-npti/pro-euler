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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import projecteuler.PrimeUtils;

/**
 *
 * @author Shamshad Alam
 */
public class ConsPrimeSum {
    public static int solve() {
        List<Integer> p = new ArrayList<>(100000);
        Iterator<Integer> itr = PrimeUtils.primeIterator();
        int k;
        while ((k = itr.next()) < 1000000) {
            p.add(k);
        }
        int max = 0, maxl = 0;
        for (int i = 0; i < p.size(); i++) {
            int sum = 0, t = 0;
            for (int j = i; j < p.size(); j++) {
                sum += p.get(j);
                if (sum > 1000000) {
                    if (t > maxl) {
                        max = k;
                        maxl = t;
                    }
                    break;
                } else {
                    if (PrimeUtils.isPrime(sum)) {
                        t = j - i + 1;
                        k = sum;
                    }
                }
            }
        }
        return max;
    }
}
