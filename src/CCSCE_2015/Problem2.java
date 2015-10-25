package CCSCE_2015;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * CCSCE 2015 - Stockton University, NJ
 *
 * Question 2: Odometer Factory
 *
 * Using BigInteger to convert bases. 
 * @author Brian Fekete
 */
public class Problem2 {

    public static void main(String[] args) {
        Scanner line = new Scanner(System.in);
        while (line.hasNext()) {
            int base = line.nextInt(); // Number from 0 - 9
            if (base == -1) {
                break;
            }

            int digits = line.nextInt(); // Number from 4 - 20
            BigInteger value = new BigInteger(line.next(), base);
            int increment = line.nextInt();

            for (int i = 0; i < increment; i++) {
                value = value.add(BigInteger.ONE);
                String output = value.toString(base);

                // Prepend 0's to meet digits requirement
                for (int j = output.length(); j < digits; j++) {
                    output = "0" + output;
                }
                // Cut off any roll overs
                output = output.substring(output.length() - digits);

                // Display output
                System.out.println(output);
            }

        }
    }
}
