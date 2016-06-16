import java.io.*;
import java.util.*;

public class p1 {

	public static int getNumTiles(int l, int w) {
		
		int min = Math.min(l, w);
		int max = Math.max(l, w);
		//System.out.println(max + " " + min);
		int power = 1;
		while (power <= min) {
			power *= 2;
		}
		power /= 2;
		int total = (int)max/power; 
		if (max%power != 0) {
			total += getNumTiles(max%power, power);
		}
		if (min%power != 0) {
			total += getNumTiles(max, min%power);
		}
		return total;
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader in =  new BufferedReader(new FileReader("DATA10.txt"));//verify name BEFORE judging

			for (int test = 0; test < 5; test++) {// change to # test cases
				try {
					String[] tokens = in.readLine().split(" ");
					int l = Integer.parseInt(tokens[0]);
					int w = Integer.parseInt(tokens[1]);
					
					System.out.println(getNumTiles(l,w) + " tiles are needed for a " + l + " by " + w +" floor");
					

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


