import java.io.*;
import java.util.*;

public class p3 {

	public static void main(String[] args) {
		
		try{
		Scanner in = new Scanner(new FileReader("C:/Users/THMKG/Downloads/ECOOboard2014/ECOO 2014 Round 1/data/DATA32.txt"));
		for (int t = 0; t < 5; t++) {
		int row = in.nextInt();
		int col = in.nextInt();
		boolean[][] taken = new boolean[row][col];
		char[][] game = new char[row][col];
		for (int r = 0; r< row; r++) {
			String line = in.next();
			for (int c = 0; c< col; c++) {
				game[r][c] = line.charAt(c);
			}
		}
		int words = in.nextInt();
		String word = in.nextLine();
		String reverse = "";
		String line = "";
		Loop:
		for (int i = 0; i< words; i++) {
			word = in.nextLine();
			word = word.replaceAll("[^A-Z]", "");
			reverse = new StringBuffer(word).reverse().toString();
			////System.out.println(word);
			////System.out.println(reverse);
			for (int r = 0; r< row; r++) {
				line = "";
				for (int c = 0; c< col; c++) {
					line += game[r][c];
				}
				if (line.indexOf(word) > -1) {
					for (int l = 0; l < word.length(); l++){
						taken[r][line.indexOf(word) + l] = true;
					}
					continue Loop;
				} else if (line.indexOf(reverse) > -1) {
					for (int l = 0; l < word.length(); l++){
						taken[r][line.indexOf(reverse) + l] = true;
					}
					continue Loop;
				}
			}
			for (int c = 0; c< col; c++) {
				line = "";
				for (int r = 0; r< row; r++) {
					line += game[r][c];
				}
				if (line.indexOf(word) > -1) {
					for (int l = 0; l < word.length(); l++){
						taken[line.indexOf(word) + l][c] = true;
					}
					continue Loop;
				} else if (line.indexOf(reverse) > -1) {
					for (int l = 0; l < word.length(); l++){
						taken[line.indexOf(reverse) + l][c] = true;
					}
					continue Loop;
				}
			}
			for (int r = 0; r< row; r++) {
				line = "";
				for (int c = 0,  R = r; c< col && R<row && R > -1; c++, R++) {
					line += game[R][c];
				}
				if (line.indexOf(word) > -1) {
					for (int l = 0; l < word.length(); l++){
						taken[r+l+line.indexOf(word)][line.indexOf(word) + l] = true;
					}
					continue Loop;
				} else if (line.indexOf(reverse) > -1) {
					for (int l = 0; l < word.length(); l++){
						taken[r+l+line.indexOf(reverse)][line.indexOf(reverse) + l] = true;
					}
					continue Loop;
				}
			}
			for (int r = 0; r< row; r++) {
				line = "";
				for (int c = 0,  R = r; c< col && R<row && R > -1; c++, R--) {
					line += game[R][c];
				}
				if (line.indexOf(word) > -1) {
					for (int l = 0; l < word.length(); l++){
						taken[r-l-line.indexOf(word)][line.indexOf(word) + l] = true;
					}
					continue Loop;
				} else if (line.indexOf(reverse) > -1) {
					for (int l = 0; l < word.length(); l++){
						taken[r-l-line.indexOf(reverse)][line.indexOf(reverse) + l] = true;
					}
					continue Loop;
				}
			}
			for (int c = 0; c< col; c++) {
				line = "";
				for (int r = 0,  C = c; C< col && r<row && C > -1; C++, r++) {
					line += game[r][C];
				}
				if (line.indexOf(word) > -1) {
					for (int l = 0; l < word.length(); l++){
						taken[line.indexOf(word) + l][c+l+line.indexOf(word)] = true;
					}
					continue Loop;
				} else if (line.indexOf(reverse) > -1) {
					for (int l = 0; l < word.length(); l++){
						taken[line.indexOf(reverse) + l][c+l+line.indexOf(reverse)] = true;
					}
					continue Loop;
				}
			}
			for (int c = 0; c< col; c++) {
				line = "";
				for (int r = row-1,  C = c; C< col && r<row && C > -1 && r > -1; C++, r--) {
					line += game[r][C];
				}
				if (line.indexOf(word) > -1) {
					for (int l = 0; l < word.length(); l++){
						taken[row -1 -line.indexOf(word) - l][c+l+line.indexOf(word)] = true;
					}
					continue Loop;
				} else if (line.indexOf(reverse) > -1) {
					for (int l = 0; l < word.length(); l++){
						taken[row -1 -line.indexOf(reverse) - l][c+l+line.indexOf(reverse)] = true;
					}
					continue Loop;
				}
			}
		}
		String output = "";
		for (int r = 0; r< row; r++) {
			for (int c = 0; c< col; c++) {
				if (taken[r][c] == false) {
					output += game[r][c];
				}
			}
		}
		System.out.println(output);
		}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
