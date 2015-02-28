package projecteuler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.BitSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shame
 */
public class PrimeUtils {
    private static final int OFFSET = 65536; // eight times more entries [upto 4 million]
    private static final long[] PRIME_TABLE = new long[OFFSET];
    static {
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("prime-table"))) {
                int k = 0;
                while (k < OFFSET) {
                    PRIME_TABLE[k++] = ois.readLong();
                }
            }
        } catch (Exception ex) {
            System.out.println("Unable to load prime table");
        }
    }

    public static boolean isPrime(int n) {
        if(n == 2) return true;
        else if((n & 1) == 0) return false;
        else return ((PRIME_TABLE[n >> 7] >>> ((n >> 1) & 63)) & 1) != 0;
    }
    
    public static int factorSum(int n) {
        if(n == 1)
            return 1;
        else if(isPrime(n))
            return n + 1;
        else {
            Iterator<Integer> itr = PrimeUtils.primeIterator();
            int sum = 1;
            while(n != 1) {
                int p = itr.next();
                if(n % p == 0) {
                    int s = 1;
                    while(n % p == 0) {
                        n /= p;
                        s = s * p + 1;
                    }
                    sum *= s;
                    if(isPrime(n))
                    {
                        sum *= (n + 1);
                        break;
                    }
                }
            }
            return sum;
        }
    }
    
    public static int properFactorSum(int n) {
        return factorSum(n) - n;
    }
    
    private static int pt() throws FileNotFoundException, IOException {
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
            Pack.PACK.add(!bt.get(i));
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
        private static final Pack PACK = new Pack();
        private long pack = 0;
        private long c = 0;
        private ObjectOutputStream out;

        public Pack() {
            try {
                this.out = new ObjectOutputStream(new FileOutputStream("prime-table"));
            } catch (IOException ex) {
                Logger.getLogger(PrimeUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private void finish() throws IOException {
            out.flush();
            out.close();
        }
        private void add(boolean b) throws IOException {
            pack = (pack >>> 1);
            if(b) {
                pack |= (1L << 63);
            }
            c++;
            if(c == 64) {
                c = 0;
                out.writeLong(pack);
                pack = 0;
            }
        }
    }
}
