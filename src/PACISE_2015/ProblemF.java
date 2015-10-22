package PACISE_2015;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * PACISE 2015 Problem F: Drone Flight
 * 
 * Sloppy code, I hate formatting problems
 * 
 * Give a Hexadecimal, convert to binary,
 * 
 * Each binary digit represents the drones movement 1 = up 0 = down
 * 
 * Drone always starts at ground level
 * 
 * Max height the drone can fly once off of the ground is 50. The output then at
 * most can have 52.
 * 
 * The top 50 rows show the drone flight (D). Next row shows the drone on the
 * ground. Last row shows the ground (X).
 * 
 * @author Brian Fekete
 *
 */
public class ProblemF {
	public static void main(String[] args) {
		int lineIndex = 2; // Ground at 2
		int maxHeight = -100;
		Scanner sc = new Scanner(System.in);
		String hex = hexToBinary(sc.next());
		// System.out.println(hex);

		// Get the max height of the drone
		for (int i = 0; i < hex.length(); i++) {
			// System.out.println(hex.substring(i, i + 1));
			String binaryDigit = hex.substring(i, i + 1);

			if (binaryDigit.equals("1")) {
				lineIndex++;
			} else if (binaryDigit.equals("0") && lineIndex != 2) {
				lineIndex--;
			}

			// Getting max height
			if (lineIndex > maxHeight)
				maxHeight = lineIndex;
		}
		String lines[] = new String[maxHeight];
		// initialize array to strings with a space
		// Since Drone always starts on the lines[0]
		for (int i = 1; i < lines.length; i++) {
			lines[i] = " ";
		}
		lines[0] = ""; // Since not initialized above
		lines[1] = "D"; // drone starting point
		// Initialize ground
		for (int i = 0; i < hex.length() + 1; i++) {
			lines[0] += "X";
		}

		lineIndex = 1; // initialized at ground flight level
		for (int i = 0; i < hex.length(); i++) {
			// System.out.println(hex.substring(i, i + 1));
			String binaryDigit = hex.substring(i, i + 1);

			if (binaryDigit.equals("1")) {
				lineIndex++;
			} else if (binaryDigit.equals("0") && lineIndex > 1) {
				lineIndex--;
			}
			
			// Place Drone
			for (int j = 1; j < lines.length; j++) {
				if (j == lineIndex) {
					lines[lineIndex] += "D";
				} else {
					lines[j] += " ";
				}
			}
		}

		// System.out.println("Max Height: " + maxHeight);

		// Display output
		for (int i = lines.length - 1; i >= 0; i--) {
			System.out.println(lines[i]);
		}
		sc.close();
	}

	// Since integer has a max value of something 65k something
	public static String hexToBinary(String s) {
		return new BigInteger(s, 16).toString(2);
	}
}
