package projecteuler;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author shame
 */
public class Permutation {
    public static String nextPermutation(String perm) {
        return sequenceNext(perm, (a, b) -> (a - b));
    }

    public static String previousPermutation(String perm) {
        return sequenceNext(perm, (a, b) -> (b - a));
    }

    private static String sequenceNext(String perm, Comparator<Character> comparator) {
        char[] chr = perm.toCharArray();
        int l = perm.length(), i = l - 1;
        SortedSet<Character> buffer = new TreeSet<>(comparator);
        while (i > 0 && chr[i] > chr[i - 1]) {
            buffer.add(chr[i]);
            i--;
        }
        if (i != 0) {
            buffer.add(chr[i]);
            char c = chr[i - 1];
            chr[i - 1] = buffer.tailSet(c).first();
            buffer.remove(chr[i - 1]);
            buffer.add(c);
            for (Character k : buffer) {
                chr[i++] = k;
            }
            return new String(chr);
        } else {
            throw new RuntimeException("No such permutation exists");
        }
    }
}
