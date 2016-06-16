import java.io.*;
import java.util.*;

public class p0 {

	public static void main(String[] args) {
		try {
			BufferedReader in =  new BufferedReader(new FileReader("DATA01.txt"));//verify name BEFORE judging

			for (int test = 0; test < 5; test++) {// change to # test cases
				try {
					
					int numberOfAlphabets = Integer.parseInt(in.readLine());
					
					char[] alphabetString = in.readLine().toCharArray();
					char[] alplhabetStringClone = alphabetString.clone();
					
					Arrays.sort(alphabetString);
					
					if(Arrays.toString(alphabetString).equals(Arrays.toString(alplhabetStringClone))){
						System.out.println(numberOfAlphabets + " IN ORDER");
					}else{
						System.out.println(numberOfAlphabets + " NOT IN ORDER");
					}
					

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


