package projecteuler.twenty_thirty;

/**
 *
 * @author shame
 */
public class CollatzLargest {
    public static long solve() {
        int start = 1, end = 1000000, count, num = 0, max = 0;
        int[] buffer = new int[end];
        long seq;
        while(start < end) {
            seq = start;
            count = 1;
            while(seq != 1) {
                if(seq - (seq & (-seq)) == 0 || seq < start) {
                    if(seq < start)
                        count += buffer[(int)seq];
                    else
                        count += Long.numberOfTrailingZeros(seq) + 1;                        
                    break;
                } else {
                    count ++;
                    if((seq & 1) == 1)
                        seq = seq * 3 + 1;
                    else 
                        seq /= 2;                    
                }
            }
            buffer[start] = count;
            if(count > max) {
                num = start;
                max = count;
            }
            start ++;
        }
        return num;
    }
}
