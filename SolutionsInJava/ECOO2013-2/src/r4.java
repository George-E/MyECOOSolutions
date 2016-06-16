import java.io.*;
import java.util.*;

public class r1 {

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File("DATA10.txt"));
			String input;
			int[] count = new int[20];
			int max;
			int lowestVal;
			int height;
			for (int i = 0; i < 5; i++) {
				Arrays.fill(count, 0);
				input = in.nextLine();
				max = input.length() - 1;
				height = 0;
				while (input.charAt(1) != '=') {
					height++;
					for (int n = 1; n < input.length() - 1; n++) {
						if (input.charAt(n) == 'O')
							count[n - 1]++;
					}
					input = in.nextLine();
				}
				lowestVal = 20;
				for (int n = 0; n < max-1; n++) {
					if (count[n] < lowestVal)
						lowestVal = count[n];
				}
				if (lowestVal > 0)
					for (int n = 0; n < max; n++) {
						count[n] -= lowestVal;
					}
				char[][] output = new char[max + 1][height + 1];
				for (int n = 0; n < height; n++) {
					output[0][n] = '|';
					output[max][n] = '|';
				}
				for (int n = 0; n < max + 1; n++) {
					output[n][height] = '=';
				}
				for (int n = 0; n < max; n++) {
					for (int m = 0; m < count[n]; m++) {
						output[max-1-n][height - 1 - m] = 'O';
					}
				}
				for (int m = 0; m < height + 1; m++) {
					for (int n = 0; n < max + 1; n++) {
						System.out.print(output[n][m]);
					}
					System.out.println();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
