import java.io.*;
import java.util.*;

public class p3 {

	public static void main(String[] args) {
		try {
			BufferedReader in =  new BufferedReader(new FileReader("DATA30.txt"));//verify name BEFORE judging

			for (int test = 0; test < 1; test++) {// change to # test cases
				try {
					String[] tokens = in.readLine().split(" ");
					int x =  Integer.parseInt(tokens[0]);
					int y =  Integer.parseInt(tokens[1]);
					String search = in.readLine();
					
					char[][] grid = new char[y][x];
					for (int j = 0; j < y; j++) {
						String line = in.readLine();
						//System.out.println(line);
						for (int i = 0; i < x; i++) {
							grid[j][i] = line.charAt(i);
						}
					}
					
					/*for (int i=0; i<grid.length;i++) {
						for (int p=0;p<grid[i].length;p++) {
							System.out.print(grid[i][p]);
						}
						System.out.println();
					}*/
					
					
					

					
				} catch (Exception e) {
					System.out.println("Test case had exception...");
					e.printStackTrace();
				} 
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found...");
		}
	}
}


