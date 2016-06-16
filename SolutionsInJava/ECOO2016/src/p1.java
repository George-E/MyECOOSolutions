import java.io.*;
import java.util.*;

public class p1 {

	public static void main(String[] args) {
		try {
			BufferedReader in =  new BufferedReader(new FileReader("DATA12.txt"));//verify name BEFORE judging

			for (int test = 0; test < 10; test++) {// change to # test cases
				try {
					
					String[] tokens = in.readLine().split(" ");
					int[] weights = new int[4];
					
					for(int x = 0; x < weights.length; x++){
						weights[x] = Integer.parseInt(tokens[x]);
					}
					
					int students = Integer.parseInt(in.readLine());
					int studentsPassed = 0;
					
					for(int y = 0; y < students; y++){
						tokens = in.readLine().split(" ");
						float mark =0;
						for(int x = 0; x < tokens.length; x++){
							mark += Integer.parseInt(tokens[x])*(weights[x]/100.0);
							
						}
						//System.out.println(mark);
						if(mark >= 50){
							studentsPassed++;
						}
					}
					System.out.println(studentsPassed);

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


