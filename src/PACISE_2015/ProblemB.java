package PACISE_2015;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * PACISE 2015 - Problem B Haul Visual
 *
 * Test Case 23 29 7 22 15 20 26 100
 *
 * @author bjf73558
 */
public class ProblemB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        int mean;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        // Reading in input
        while (sc.hasNextInt()) {
            // Find Minimum
            int tempNum = sc.nextInt();

            if (tempNum > 50) { // For netbeans debugging 
                break;
            }

            numbers.add(tempNum);
            if (tempNum < min) {
                min = tempNum;
            }
        }

        // Get sum using a for each loop
        for (Integer i : numbers) {
            sum += i;
        }

        // Find the mean
        mean = sum / numbers.size();

        // Output the mean
        System.out.println("Mean " + mean);

        // Find the minimum amount of space before the seperator | 
        int minSpace = mean - min;
        if (min > 9) {
            minSpace += 3; // Because 2 digit number + space 
        } else {
            minSpace += 2; // 1 digit and space
        }
        String space = "";

        for (int i = 0; i < minSpace; i++) {
            space += " ";
        }
        space += "|";

        // iterate through inputs and output it
        // For each loop
        for (Integer i : numbers) {
            String output = "";
            int num =  i;
            if (num > mean) { // Greater
                output = space;
                for (int j = 0; j < num - mean; j++) {
                    output += "+";
                }
                output += " " + num;
            } else if (num < mean) { // Left
                int spaceBefore = num - min;

                // Deals with the issue of min and num having different number
                // of digits which throws off formatting
                if (min > 9 && num < 9 || min < 9 && num > 9) {
                    spaceBefore -= 1;
                }
                for (int j = 0; j < spaceBefore; j++) {
                    output += " ";
                }
                output += num + " ";
                for (int j = 0; j < mean - num; j++) {
                    output += "-";
                }
                output += "|";
            } else { // Num is mean
                output = space;
                if (mean == min) { // No space in the beginning if mean is min
                    output = "| " + num;
                } else {
                    output += " " + num;
                }
            }
            System.out.println(output);
        } // End of for each loop

    } // End of Main

}
