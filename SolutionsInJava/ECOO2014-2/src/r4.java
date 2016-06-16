import java.io.*;
import java.util.*;

public class r4 {

	static char[][] board = new char[6][6];
	static List<String> spots = new ArrayList<String>();

	static void move(int x, int y, int dir) {
		if (spots.contains(x + "" + y + "" + dir) || x > 5)
			return;
		else
			spots.add(x + "" + y + "" + dir);
		// System.out.println(x +" "+ y+" "+dir);
		if (board[x][y] == 'S') {
			if (dir == 0) {
				for (int i = x - 1; i > 0; i--) {
					switch (board[i][y]) {
					case 'U':
						move(x - 1, y, dir);
						break;
					}
				}
			}
		} else if (x < 5 && x > 0 && y < 5 && y > 0) {
			if (dir == 0) {
				for (int i = x - 1; i > 0; i--) {
					switch (board[i][y]) {
					case 'U':
						move(x - 1, y, dir);
						break;
					case 'D':
						move(x + 1, y, dir);
						break;
					case 'L':
						move(x, y - 1, dir);
						break;
					case 'R':
						move(x, y + 1, dir);
						break;
					case 'C':
						if (dir == 3)
							move(x, y, 0);
						else
							move(x, y, dir + 1);
						break;
					case 'B':
						if (dir == 0)
							move(x, y, 3);
						else
							move(x, y, dir - 1);
						break;
					}
				}
			} else if (dir == 1) {
				for (int i = y + 1; i < 5; i++) {
					switch (board[x][i]) {
					case 'U':
						move(x - 1, y, dir);
						break;
					case 'D':
						move(x + 1, y, dir);
						break;
					case 'L':
						move(x, y - 1, dir);
						break;
					case 'R':
						move(x, y + 1, dir);
						break;
					case 'C':
						if (dir == 3)
							move(x, y, 0);
						else
							move(x, y, dir + 1);
						break;
					case 'B':
						if (dir == 0)
							move(x, y, 3);
						else
							move(x, y, dir - 1);
						break;
					}
				}
			} else if (dir == 2) {
				for (int i = x + 1; i < 5; i++) {
					switch (board[i][y]) {
					case 'U':
						move(x - 1, y, dir);
						break;
					case 'D':
						move(x + 1, y, dir);
						break;
					case 'L':
						move(x, y - 1, dir);
						break;
					case 'R':
						move(x, y + 1, dir);
						break;
					case 'C':
						if (dir == 3)
							move(x, y, 0);
						else
							move(x, y, dir + 1);
						break;
					case 'B':
						if (dir == 0)
							move(x, y, 3);
						else
							move(x, y, dir - 1);
						break;
					}
				}
			} else if (dir == 3) {
				for (int i = y - 1; i > 0; i--) {
					switch (board[x][i]) {
					case 'U':
						move(x - 1, y, dir);
						break;
					case 'D':
						move(x + 1, y, dir);
						break;
					case 'L':
						move(x, y - 1, dir);
						break;
					case 'R':
						move(x, y + 1, dir);
						break;
					case 'C':
						if (dir == 3)
							move(x, y, 0);
						else
							move(x, y, dir + 1);
						break;
					case 'B':
						if (dir == 0)
							move(x, y, 3);
						else
							move(x, y, dir - 1);
						break;
					}
				}
			}
		} else if (board[x][y] == 'T') {
			board[x][y] = 'Y';
		}
	}

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File("DATA41.txt"));
			for (int i = 0; i < 10; i++) {// change to 10
				Arrays.fill(board[0], '.');
				Arrays.fill(board[1], '.');
				Arrays.fill(board[2], '.');
				Arrays.fill(board[3], '.');
				Arrays.fill(board[4], '.');
				Arrays.fill(board[5], '.');
				spots.clear();
				int x = 0, y = 0;
				for (int n = 0; n < 6; n++) {
					String line = in.nextLine();
					for (int k = 0; k < 6; k++) {
						// System.out.println(n + " " + k + " " +
						// line.length());
						board[n][k] = line.charAt(k);
						if (line.charAt(k) == 'S') {
							x = n;
							y = k;
						}
					}
				}

				move(x, y, 0);
				/*
				 * for (int n = 0; n < 6; n++) { for (int k = 0; k < 6; k++) {
				 * System.out.print(board[n][k]); } System.out.println(); }
				 */
				for (int n = 0; n < 6; n++) {
					for (int k = 0; k < 6; k++) {
						if (board[n][k] == 'Y') {
							System.out.print('T');
						} else if (board[n][k] == 'T') {
							System.out.print('F');
						}
					}
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
