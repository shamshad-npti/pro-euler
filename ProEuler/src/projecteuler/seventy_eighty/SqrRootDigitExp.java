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

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Shamshad Alam
 */
public class SqrRootDigitExp {
    public static int solve() {
        int ans = 0, p = 1;
        Set<Integer> sqrt = new HashSet<>();
        sqrt.addAll(Arrays.asList(1, 4, 9, 16, 25, 36, 49, 64, 81));

        for (int i = 2; i < 100; i++) {
            if (sqrt.contains(i)) {
                p = (int) Math.sqrt(i);
                continue;
            }
            ans += digit_sum(i, p);
            System.out.println(" " + i + " " + p + " " + ans);
        }
        return ans;
    }

    private static int digit_sum(long n, long b) {
        int s = 0, c = 0, i = 0;
        BigInteger num = BigInteger.valueOf(n);
        BigInteger k = BigInteger.valueOf(b);
        BigInteger hun = BigInteger.valueOf(100);
        BigInteger j;
        num = num.subtract(k.multiply(k));
        k = k.shiftLeft(1);
        while (c < 100) {
            c++;
            num = num.multiply(hun);
            k = k.multiply(BigInteger.TEN);
            for (i = 0, j = BigInteger.ONE; k.add(j).multiply(j).subtract(num).signum() == -1; i++, j = j.add(BigInteger.ONE));
            j = j.subtract(BigInteger.ONE);
            num = num.subtract(k.add(j).multiply(j));
            k = k.add(j.shiftLeft(1));
            s += i;
            System.out.print(i);
        }
        return s;
    }
}
