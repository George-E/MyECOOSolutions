import java.io.*;
import java.util.*;

public class p4 {

	public static void main(String[] args) {

		try {
			Scanner in = new Scanner(new File("DataTest.txt"));
			for (int test = 0; test < 1; test++) {//change to # test cases
				int rects = in.nextInt();
				int[][] rectangles = new int[rects][2];
				int area = 0;
				ArrayList<Integer> permutations;
				ArrayList<Integer> factors = new ArrayList<Integer>();
				
				for(int x = 0; x < rects; x++){
					
					rectangles[x][0] = in.nextInt();
					rectangles[x][1] = in.nextInt();
					area += rectangles[x][0] * rectangles[x][1];
				}
				
				for(int x = 1; x <= area; x++){
					
					if(area % x == 0 ){
						
						factors.add(x);
						//System.out.println(x);
					}
					
				}
				List<Integer> lengths = new ArrayList<Integer>();
				
				for(int p = 0; p < rects ; p++){
				for(int x = 0; x < rects ; x++){
					if (x != p)
					for(int y = 0; y < 2 ; y++){
						//lengths.add(rectangles[p])
					}
					
				}
				}
				
			} 
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
