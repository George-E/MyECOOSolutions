import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

public class p1 {

	public static void main(String[] args) {
		double[][] input = new double[10][5];
		try {
			String fileName = "C:/Users/THMKG/Downloads/ECOOboard2014/ECOO 2014 Round 1/data/DATA10.txt";
			Scanner in = new Scanner(new File(fileName));
			for (int i = 0; i < 10; i++) {
				input[i][0] = (in.nextInt() * 24 * 60 * 60)+ (in.nextInt() * 60 * 60) + (in.nextInt() * 60);
				input[i][1] = Math.floor(input[i][0] * 86400 / 88642.663);
				input[i][2] = Math.floor(input[i][1] / 86400);
				input[i][3] = Math.floor((input[i][1] - (input[i][2] * 86400)) / 3600);
				input[i][4] = Math.round((input[i][1] - (input[i][2] * 86400) - (input[i][3] * 3600)) / 60) +36;
				if (input[i][4] > 59) {
					input[i][3] += 1;
                    input[i][4] -= 60;
                }
			}
			for (int i = 0; i < 10; i++) {
				DecimalFormat df = new DecimalFormat("00");
				System.out.println("Day " + df.format(input[i][2]) + ", "
						+ df.format(input[i][3]) + ":"
						+  df.format(input[i][4]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
} 
