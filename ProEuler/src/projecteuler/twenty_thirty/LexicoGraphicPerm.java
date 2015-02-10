package projecteuler.twenty_thirty;

import java.util.Arrays;

/**
 *
 * @author shame
 */
public class LexicoGraphicPerm {
    public static String solve() {
        return lexicographicPermutation("0123456789", 1000000);
    }
    
    private static String lexicographicPermutation(String str, long i) {
        int j = 0, k, l = str.length();
        char[] chr = str.toCharArray();
        Arrays.sort(chr);
        while(i > 1) {
            long fact = fact(l - j - 1);
            if(fact <= i) {
                int inx = (int)((i - 1) / fact);
                k = j + inx;
                char t = chr[k];
                while(k > j)
                    chr[k] = chr[--k];
                chr[k] = t;
                i -= inx * fact;
            }
            j++;
        }
        return new String(chr);
    }
    
    private static long fact(long a) {
        return a <= 1 ? 1 : a * fact(a - 1);
    }
}
