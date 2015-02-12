package projecteuler;

import java.util.Arrays;

/**
 *
 * @author shame
 */
public class Permutation {
    public static String nextPermutation(String perm) {
        char[] chr = perm.toCharArray();
        int l = perm.length(), i = l - 1;
        while(i > 0 && chr[i] < chr[i - 1])
            i--;
        if(i != 0) {
            int k = i;
            char c = chr[i - 1], min = chr[i];
            for(int j = i + 1; j < l; j++)
                if(chr[j] > c && chr[j] < min) {
                    min = chr[j];
                    k = j;
                }
            char t = chr[k];
            chr[k] = chr[i - 1];
            chr[i - 1] = t;
            Arrays.sort(chr, i, l);
            return new String(chr);
        } else {
            return null;
        }
    }
}
