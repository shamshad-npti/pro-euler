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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author shame
 */
public class CodedTriangNum {
    public static int solve() throws FileNotFoundException {
        int ans = 0;
        Scanner in = new Scanner(new File("p042_words.txt"));
        Matcher matcher = Pattern.compile("[A-Z]+").matcher(in.next());
        while (matcher.find()) {
            if (test(code(matcher.group()))) {
                ans++;
            }
        }
        return ans;
    }

    private static int code(String name) {
        int c = 0;
        for (char h : name.toCharArray()) {
            c += h - 'A' + 1;
        }
        return c;
    }

    private static boolean test(int score) {
        int r = 5000, l = 0, m, n;
        while (l < r) {
            m = (l + r) >> 1;
            n = m * (m + 1) / 2;
            if (n == score) {
                return true;
            } else if (n > score) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
