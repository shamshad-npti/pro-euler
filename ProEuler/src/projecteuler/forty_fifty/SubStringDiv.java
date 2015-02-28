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

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author shame
 */
public class SubStringDiv {
    public static long solve() {
        Map<Long, Long> map = new HashMap<>();
        long[] test = {13, 11, 7, 5, 3, 2};
        int r = 0;
        for (long i = 17; i < 1000; i += 17) {
            r++;
            if (check5(i))
                map.put(i, i / 10);
        }
        int mult = 10;
        for (long k : test) {
            Map<Long, Long> aux = new HashMap<>();
            final int m = mult;
            map.forEach((a, b) -> {
                for (int i = b < 10 ? 100 : 0; i < 1000; i += 100) {
                    if ((i + b) % k == 0 && check(b * m + a % m, i / 100)) {
                        aux.put((i + b) * m + a % m, (i + b) / 10);
                    }
                }
            });
            map = aux;
            mult *= 10;
        }
        long ans = 0;
        for (long l : map.keySet()) {
            boolean[] used = new boolean[10];
            int d = (int) l;
            while (d != 0) {
                used[d % 10] = true;
                d /= 10;
            }
            int un = 0, i = 0;
            while (used[i]) {
                un = ++i;
            }
            ans += un * 1000000000L + l;
        }
        return ans;
    }

    private static boolean check5(long n) {
        long k = 0, d;
        while (n != 0) {
            d = n % 10;
            if (d == 5 || ((k >> d) & 1) == 1) {
                return false;
            }
            n /= 10;
            k = k | (1 << d);
        }
        return true;
    }

    private static boolean check(long n, int d) {
        while (n != 0) {
            if (n % 10 == d) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
