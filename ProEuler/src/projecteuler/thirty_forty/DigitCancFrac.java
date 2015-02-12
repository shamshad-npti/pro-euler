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

/**
 *
 * @author shame
 */
public class DigitCancFrac {

    public static int solve() {
        int den = 1, num = 1;
        for (int n = 11; n < 100; n++) {
            if (n % 10 != 0) {
                int n1 = n / 10, n2 = n % 10;
                for (int d = n + 1; d < 100; d++) {
                    int d1 = d / 10, d2 = d % 10;
                    if ((n1 == d1 && comp(n, d, n2, d2))
                            || (n1 == d2 && comp(n, d, n2, d1))
                            || (n2 == d1 && comp(n, d, n1, d2))
                            || (n2 == d2 && comp(n, d, n1, d1))) {
                        num *= n;
                        den *= d;
                    }
                }
            }
        }
        return den / gcd(den, num);
    }

    private static boolean comp(int n1, int d1, int n2, int d2) {
        if (n1 < d1 && n2 < d2) {
            int g1 = gcd(d1, n1);
            int g2 = gcd(d2, n2);
            return (d1 / g1) == (d2 / g2) && (n1 / g1) == (n2 / g2);
        }
        return false;
    }

    private static int gcd(int i, int j) {
        return j == 0 ? i : gcd(j, i % j);
    }

}
