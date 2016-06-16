import java.io.*;
import java.util.*;

public class r1 {

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File("DATA11.txt"));
			for (int i = 0; i < 10; i++) {// change to 10
				int[] legend = { 1, 2, 5, 10, 50, 100, 1000, 10000, 500000,
						1000000 };
				int[] amounts = new int[10];
				int qs = 0;
				for (int n = 0; n < 9; n++) {
					String num = in.nextLine();
					if (num.equals("?")) {
						qs++;
						continue;
					}
					int number = Integer.parseInt(num.substring(1));
					switch (number) {
					case 1:
						amounts[0]++;
						break;
					case 2:
						amounts[1]++;
						break;
					case 5:
						amounts[2]++;
						break;
					case 10:
						amounts[3]++;
						break;
					case 50:
						amounts[4]++;
						break;
					case 100:
						amounts[5]++;
						break;
					case 1000:
						amounts[6]++;
						break;
					case 10000:
						amounts[7]++;
						break;
					case 500000:
						amounts[8]++;
						break;
					case 1000000:
						amounts[9]++;
						break;
					}
				}
				String output = "No Prizes Possible";
				List<Integer> poss = new ArrayList<Integer>();
				Loop: for (int n = 0; n < 10; n++) {
					if (amounts[n] == 3) {
						output = "$" + legend[n];
						break Loop;
					}

					if (qs == 1) {
						if (amounts[n] == 2) {
							output = "";
							poss.add(legend[n]);
						}
					}

					if (qs > 1) {
						if (amounts[n] > 0) {
							output = "";
							poss.add(legend[n]);
						}
					}

					if (qs >= 3) {
						poss.clear();
						output = "";
						for (int t = 0; t < 10; t++) {
							poss.add(legend[t]);
						}
						break Loop;
					}

				}

				if ((output.equals(""))) {
					for (int p : poss) {
						output += "$" + p + " ";
					}
				}
				System.out.println(output);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
