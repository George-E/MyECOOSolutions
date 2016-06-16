import java.io.*;
import java.util.*;

public class p1 {

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File("DATA11.txt"));

			for (int test = 0; test < 10; test++) {// change to # test cases
				try {
					String line1 = in.nextLine();
					String line2 = in.nextLine();
					String outputUncut = "";

					String[] words = line2.split(" ");
					boolean encoding = (line1.equals("encode"));

					int index = 0;
					if (encoding) {
						while (true) {
							boolean found = false;
							for (int i = 0; i < words.length; i++) {
								if (index < words[i].length()) {
									outputUncut += words[i].charAt(index);
									found = true;
								}
							}
							if (!found) {
								break;
							}
							index++;
						}

						index = 0;
						for (int i = 0; i < words.length; i++) {
							System.out.print(outputUncut.substring(index, index + words[i].length()) + " ");
							index += words[i].length();
						}
						System.out.println();

					} else {
						index = 0;
						line2 = line2.replace(" ", "");
						String[] wordsOut = new String[words.length];
						for (int i = 0; i < words.length; i++) {
							wordsOut[i] = "";
						}

						int length = 0;
						while (length != line2.length()) {
							for (int i = 0; i < wordsOut.length; i++) {
								if (wordsOut[i].length() != words[i].length()) {
									wordsOut[i] += line2.charAt(index++);
									length++;
								}
							}
						}

						for (int i = 0; i < words.length; i++) {
							System.out.print(wordsOut[i] + " ");
						}
						System.out.println();
					}

				} catch (Exception e) {
					System.out.println("Test case had error...");
				} 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
