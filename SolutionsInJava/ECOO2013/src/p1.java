import java.util.*;
import java.io.*;

public class p1 {

	public static void main(String[] args) {
		
		try {
			Scanner in = new Scanner(new FileReader("C:/Users/THMKG/Downloads/ECOOCS_2013/Round 1/data/DATA11.txt"));
			int nextNumber = in.nextInt();
			int lateStudents = 0;
			int waitingStudents = 0;
			Loop:
			while (true) {
				switch (in.next()) {
				case "TAKE" :
					lateStudents++;
					waitingStudents++;
					nextNumber++;
					if (nextNumber == 1000) {
						nextNumber = 1;
					}
					break;
				case "SERVE" :
					waitingStudents--;
					break;	
				case "CLOSE" :
					System.out.println(lateStudents + " " + waitingStudents + " "  + nextNumber);
					waitingStudents = 0;
					lateStudents = 0;
					break;	
				case "EOF":
					break Loop;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}

}
