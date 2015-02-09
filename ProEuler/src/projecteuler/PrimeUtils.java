package projecteuler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author shame
 */
public class PrimeUtils {
    private static final int OFFSET = 65536; // eight times more entries [upto 4 million]
    private static final long[] PRIME_TABLE = new long[OFFSET];
    static {
        try {
            Scanner in = new Scanner(new File("primes-2"));
            int k = 0;
            while(k < OFFSET)
                PRIME_TABLE[k++] = in.nextLong();
        } catch(Exception ex) {
            System.out.println("Unable to load prime table");
        }
    }
    
    public static boolean isPrime(int n) {
        if(n == 2) return true;
        else if((n & 1) == 0) return false;
        else return ((PRIME_TABLE[n >> 7] >>> ((n >> 1) & 63)) & 1) != 0;
    }
    
    private static int pt() throws FileNotFoundException {
        System.setOut(new PrintStream("primes-2"));
        int s = 1 << 26, p = 1 << 13;
        BitSet bt = new BitSet(s);
        bt.set(0);
        for(int i = 1; i < p; i++) {
            if(!bt.get(i)) {
                int k = i + 1, j;
                for(j = k * 2; j < s; j += k) 
                    bt.set(j - 1);
            }
        }
        
        for(int i = 0; i < s; i+= 2) {
            Pack.add(!bt.get(i));
        }
        return 0;
    }
    
    public static Iterator<Integer> primeIterator() {
        return primeIterator(2);
    }
    
    public static Iterator<Integer> primeIterator(final int start) {
        return new PrimeItr(start);
    }
    
    private static class PrimeItr implements Iterator<Integer> {
        int start;
        int pos;
        int size = 20;
        int[] buffer = new int[size];

        public PrimeItr(int start) {
            int k = 0;
            this.start = start;
            if(this.start == 2)
                buffer[k++] = start;
            if((this.start & 1) == 0)
                this.start++;
            initNext(k);
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            if(pos < size)
                return buffer[pos++];
            else {
                initNext(0);
                return buffer[pos++];
            }
        }
        
        private void initNext(int k) {
            pos = 0;
            while(k < size) {
                if(isPrime(start))
                    buffer[k++] = start;
                start += 2;
            }            
        }
    }
    
    private static class Pack {
        private static long pack = 0;
        private static long c = 0;
        private static void add(boolean b) {
            pack = (pack >>> 1);
            if(b) {
                pack |= (1L << 63);
            }
            c++;
            if(c == 64) {
                c = 0;
                System.out.println(pack);
                pack = 0;
            }
        }
    }
}
