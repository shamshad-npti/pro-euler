package projecteuler.twenty_thirty;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import projecteuler.PrimeUtils;

/**
 *
 * @author shame
 */
public class NonAbundantSum {
    public static int solve() {
        int ans = 0, s = 28124, start = 10;
        Set<Integer> sets = new HashSet<>();
        while(++start < s) {
            if(PrimeUtils.properFactorSum(start) > start)
                sets.add(start);
            boolean abund = true;
            for (Integer t : sets)
                if(sets.contains(start - t)) {
                    abund = false;
                    break;
                }
            ans += abund ? start : 0;
        }
        return ans;
    }
}
