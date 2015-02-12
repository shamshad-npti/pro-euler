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

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author shame
 */
public class PanDigital {
    public static int solve() {
        int i, ans = 0;
        Set<Integer> exst = new HashSet<>();
        for (i = 2; i < 100; i++) {
            if (check(i, 1) != 1024) {
                int j = i + 1, prd = i * j;
                while (("" + i + j + (i * j)).length() < 10) {
                    if (check(j, i, prd) && !exst.contains(prd)) {
                        ans += j * i;
                        exst.add(prd);
                    }
                    prd = i * ++j;
                }
            }
        }
        return ans;
    }

    private static int check(int num, int k) {
        int r;
        while (num != 0) {
            r = num % 10;
            if (((k >>> r) & 1) == 1) {
                return 1024;
            }
            k |= (1 << r);
            num /= 10;
        }
        return k;
    }
    private static boolean check(int... nums) {
        int k = 1;
        for (int num : nums) {
            k = check(num, k);
        }
        return k == 1023;
    }
}
