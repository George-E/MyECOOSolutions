import java.io.*;
import java.util.*;

public class p2 {

	public static void main(String[] args) {
		
		String[] outputs = new String[10];
		try{
		Scanner in = new Scanner(new FileReader("C:/Users/THMKG/Downloads/ECOOboard2014/ECOO 2014 Round 1/data/DATA22.txt"));
		Loop:
		for (int i = 0; i<10; i++) {
			String lineA = in.nextLine();
			lineA = lineA.replace("T", "0"); 
			lineA = lineA.replace("A", "0");
			lineA = lineA.replace("C", "1");
			lineA = lineA.replace("G", "1");
			String lineB = in.nextLine();
			lineB = lineB.replace("T", "1");
			lineB = lineB.replace("A", "1");
			lineB = lineB.replace("C", "0");
			lineB = lineB.replace("G", "0");
			//System.out.println(lineA);//
			//System.out.println(lineB);//
		
			mainLoop:
			for (int n = 0; n<8; n++) {
				//System.out.println(outputs[i]);
				if (outputs[i] == null) {
				} else  if (outputs[i].length() > 0)
				continue Loop;
				
				int length = (lineA.length() - n)/8;
				int position = n;
				subLoop:
				for (int l = 0; l<length; l++, position+=8) {
					boolean test = false;
					if ( lineA.substring(position,position + 8).equals("00100000") ) {
						test = true;
						outputs[i] += " ";
						//System.out.print(" ");//
						continue subLoop;
					} else{
					for (int y = 65; y<=90;y++) {
						
						//System.out.println(outputs[i] + " " + position + " " + y);//
						//System.out.println(lineA.substring(position,position + 8)) ;//
						//System.out.println("0" + Integer.toBinaryString(y) + "\n") ;//	
						
						if ( lineA.substring(position,position + 8).equals("0" + Integer.toBinaryString(y)) ) {
							test = true;
							outputs[i] += (char)y;	
							//System.out.print((char)y);//
							continue subLoop;
						}
					}
					}
					if (test == false) {
						outputs[i] = "";
						continue mainLoop;
					}
				}
			}
			
			if (outputs[i].length() ==0) {
			mainLoopB:
				for (int n = 0; n<8; n++) {
					if (outputs[i] == null) {
					} else  if (outputs[i].length() > 0)
					continue Loop;
					int length = (lineA.length() - n)/8;
					int position = n;
					subLoopB:
					for (int l = 0; l<length; l++, position+=8) {
						//System.out.println(outputs[i]);//
						boolean test = false;
						if ( lineB.substring(position,position + 8).equals("00100000") ) {
							test = true;
							outputs[i] += " ";
							//System.out.print(" ");//
							continue subLoopB;
						} else{
						for (int y = 65; y<=90;y++) {
							
							if ( lineB.substring(position,position + 8).equals("0" + Integer.toBinaryString(y)) ) {
								test = true;
								outputs[i] += (char)y;	
								//System.out.println(lineB.substring(position,position + 8)) ;//
								//System.out.println("0" + Integer.toBinaryString(y) ) ;//
								//System.out.println((char)y+ "\n");//
								continue subLoopB;
							}
						}
						}
						if (test == false) {
							outputs[i] =  "";
							continue mainLoopB;
						}
					}
				}
			}
		
		}
		
		for (int i = 0; i<10; i++) {
			System.out.println(outputs[i]);		
		}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	} 

}
