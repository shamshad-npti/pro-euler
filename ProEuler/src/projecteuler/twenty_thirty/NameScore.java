package projecteuler.twenty_thirty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author shame
 */
public class NameScore {
    public static int solve() throws FileNotFoundException {
        Scanner in = new Scanner(new File("p022_names.txt"));
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("[A-Z]+");
        Matcher match = pattern.matcher(in.next());
        while(match.find())
            list.add(match.group());
        Collections.sort(list);
        int k = 'A' - 1, i = 1, ans = 0;
        for (String name : list) {
            int p = 0;
            for(char c: name.toCharArray())
                p += c - k;
            ans += (i * p);
            i++;
        }
        return ans;
    }
}
