import java.io.*;
import java.util.*;

public class p3 {

	public static void main(String[] args) {
		
		try{
		Scanner in = new Scanner(new FileReader("C:/Users/THMKG/Desktop/Georges Folder/ECOOCS_2013/Round 1/data/DATA30.txt"));
		for (int t = 0; t < 3; t++) {
		int count = 0;
		int[][] game = new int[16][16];
		for (int r = 0; r< 16; r++) {
			String line = in.next();
			for (int c = 0; c< 16; c++) {
				game[r][c] =  Character.getNumericValue(line.charAt(c));
			}
		}
		for (int r = 0; r< 16; r++) {
			Loop:
			for (int c = 0; c< 16; c++) {
				if (game[r][c] == -1) {
					Attempt:
					for (int n =0; n< 16; n++) {
						for (int p =0; p<16; p++) {
							if (game[r][p] == n) {
								continue Attempt;
							}
						}
						for (int p =0; p<16; p++) {
							if (game[p][c] == n) {
								continue Attempt;
							}
						}
						for (int p =1; p<4; p++) {
							if (r+p ==4 || r+p == 8 || r+p == 12 || r+p ==16)
								break;
							for (int s =1; s<4; s++) {
								if (c+s ==4 || c+s == 8 || c+s == 12 || c+s ==16)
									break;
								if (game[r+p][c+s] == n) {
									continue Attempt;
								}
							}
							for (int s =1; s<4; s++) {
								if (c-s ==-1 || c-s == 3 || c-s == 7 || c-s ==11)
									break;
								if (game[r+p][c-s] == n) {
									continue Attempt;
								}
							}
						}
						for (int p =1; p<4; p++) {
							if (r-p ==-1 || r-p == 3 || r-p == 7 || r-p ==11)
								break;
							for (int s =1; s<4; s++) {
								if (c+s ==4 || c+s == 8 || c+s == 12 || c+s ==16)
									break;
								if (game[r-p][c+s] == n) {
									continue Attempt;
								}
							}
							for (int s =1; s<4; s++) {
								if (c-s ==-1 || c-s == 3 || c-s == 7 || c-s ==11)
									break;
								if (game[r-p][c-s] == n) {
									continue Attempt;
								}
							}
						}
						game[r][c] = n;
						count++;
						continue Loop;
					}
				}
			}
		}
		System.out.println(count);
		
		}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
