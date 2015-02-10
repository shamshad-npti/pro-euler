package projecteuler;

import java.io.FileNotFoundException;
import projecteuler.twenty_thirty.CollatzLargest;
import projecteuler.twenty_thirty.DigitSum;
import projecteuler.twenty_thirty.FactDigitSum;
import projecteuler.twenty_thirty.LatticePath;
import projecteuler.twenty_thirty.SundayCount;
import projecteuler.twenty_thirty.TriangleSum;

/**
 *
 * @author shame
 */
public class ProjectEuler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(FactDigitSum.solve());
    }
    
}
