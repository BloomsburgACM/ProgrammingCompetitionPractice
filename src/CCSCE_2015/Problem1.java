package CCSCE_2015;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * CCSCE 2015 - Stockton University, NJ
 *
 * Question 1: Data Entry
 * 
 * Using Brett's slick way of doing this problem. Simply just add everything to
 * a collection, count the total strings, add the sum of the integers 
 * disregarding the initial value, and subtract total - sum for Boris. Doris
 * is the sum.
 *
 * @author Brian Fekete
 */
public class Problem1 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        int numberOfDataSets = scan.nextInt(); // Not needed but need to call scan.nextInt(). 
        int sumDoris = 0;
        int totalStrings = 0;
        
        while (scan.hasNext()) {
            String s = scan.next();
            if(s.equals("quit123")) break; //Dummy quit statement
            list.add(s);
        }
        for (String data : list) { // Iterate through the array list
            if(data.matches("\\d*")){ // If it is a number
                sumDoris+= Integer.parseInt(data); // Add all sums of ints
            } else { // Is a word
                totalStrings++; 
            }
        }
        System.out.println("Doris: " + sumDoris);
        System.out.println("Boris: " + (totalStrings - sumDoris));
    }

}
