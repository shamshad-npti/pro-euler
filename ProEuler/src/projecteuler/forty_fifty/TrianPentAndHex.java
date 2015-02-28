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
public class TrianPentAndHex {
    public static long solve() {
        for (int i = 144;; i++) {
            long h = (2L * i - 1) * i;
            if (isTr(h) && isPent(h)) {
                return h;
            }
        }
    }

    private static boolean isTr(long n) {
        long l = 0, r = n, mid, k;
        while (l < r) {
            mid = (r + l) >> 1;
            k = mid * (mid - 1) >> 1;
            if (k == n) {
                return true;
            } else if (k < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return false;
    }

    private static boolean isPent(long n) {
        long l = 0, r = n, mid, k;
        while (l < r) {
            mid = (r + l) >> 1;
            k = mid * (3 * mid - 1) >> 1;
            if (k == n) {
                return true;
            } else if (k < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return false;
    }
}
