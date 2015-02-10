package projecteuler.ten_twenty;

/**
 *
 * @author shame
 */
public class SundayCount {
    public static int solve() {
        int days = 2, sunday = 0;
        int[] m = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int i = 1901; i <= 2000; i++) {
            m[1] = isLeapYear(i) ? 29 : 28;
            for(int j = 0; j < 12; j++) {
                days += m[j];
                days %= 7;
                if(days == 0)
                    sunday++;
            }
        }
        return sunday;
    }
    
    private static boolean isLeapYear(int y) {
        return (y % 100) == 0 ? (y % 400) == 0 : y % 4 == 0;
    }
}
