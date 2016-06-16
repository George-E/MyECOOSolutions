import java.io.*;
import java.util.*;
public class p2 {
	public static void main(String[] args) {
		try{
			Scanner lol = new Scanner(new FileReader("DATA20.txt"));
			for (int i = 0; i<5; i++) {//change to 10	
				int width = lol.nextInt();
				String k = lol.nextLine();
				String line = lol.nextLine();
				String[] scan = line.split(" ");
				int currentLine = 0;
				for (int y = 0; y< scan.length;y++) {
					String word = scan[y];
					if (word.length() + currentLine <= width) {
						System.out.print(word+" ");
						currentLine += word.length() +1;
					} else if (word.length()> width) {
						System.out.println();
						System.out.println(word.substring(0,width));
						System.out.print(word.substring(width)+" ");
						currentLine = word.length()-width+1;
					} else {
						System.out.print("\n"+word+" ");
						currentLine = word.length()+1;
					}
				}
				System.out.println("\n=====");			
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
