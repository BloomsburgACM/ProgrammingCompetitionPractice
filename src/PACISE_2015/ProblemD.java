package PACISE_2015;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * * zero or more + one or more digit = exactly that 2- 9
 *
 * @author Brian Fekete
 */
public class ProblemD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String line = sc.nextLine();
            String pat = line.substring(0, line.indexOf(" "));
            String sentence = line.substring(line.indexOf(" ") + 1);

            // Replace the digit with {#}
            pat = pat.replaceAll("2", "{2}");
            pat = pat.replaceAll("3", "{3}");
            pat = pat.replaceAll("4", "{4}");
            pat = pat.replaceAll("5", "{5}");
            pat = pat.replaceAll("6", "{6}");
            pat = pat.replaceAll("7", "{7}");
            pat = pat.replaceAll("8", "{8}");
            pat = pat.replaceAll("9", "{9}");

            Pattern p = Pattern.compile(pat);
            Matcher m = p.matcher(sentence);

            if (m.matches()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
       }
    }
}
// a2d*b+ aabbbb
