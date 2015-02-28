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

/**
 *
 * @author Shamshad Alam
 */
public class LastDigit {

    private static final long mod = 10000000000l;

    public static long solve() {
        long ans = 0;
        for (int i = 1; i <= 1000; i++) {
            ans = (ans + power(i, i)) % mod;
        }
        return ans;
    }

    private static long power(long k, long p) {
        long r = 1;
        for (int i = 0; i < p; i++) {
            r = (r * k) % mod;
        }
        return r;
    }
}
