
import java.util.*;
public class r1 {
	
	static char whatLetter(String n) {
		int num = Integer.parseInt(n);
		return (char)(num+64);
		}
	
	static boolean isPrime(int n) {
	    if (n%2==0) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0) {
	        	//System.out.println(i + " is a factor of " + n);
	            return false;
	        }
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (int i = 0; i< 5; i++) {
			int numCodes = in.nextInt();
			int[] codes = new int[numCodes];
			for (int n = 0; n< numCodes; n++) {
				codes[n] = in.nextInt();
			}
			int key = -1;
			Loop:
			for (int n = 100001; n< 500000; n+=2) {
				key = n;
				//System.out.println(n);
				if (isPrime(n)) {
					//System.out.println(n + " is prime");
					for (int l = 0; l< numCodes; l++) {
						if (((double)codes[l]%n !=0) ) {
							continue Loop;
						}
					}
					for (int l = 0; l< numCodes; l++) {
						if (!(String.format("%04d", codes[l]/n).charAt(0) >= '0' && String.format("%04d", codes[l]/n).charAt(0) <= '3')) {
							continue Loop;
						}
					}
					break Loop;
				}
				else {
					continue;
				}
			}
			//key = 395611;
			String output = "";
			String letter;
			for (int l = 0; l< numCodes; l++) {
				codes[l] /= key;
				//System.out.println(String.format("%04d", codes[l]));
				letter = String.format("%04d", codes[l]).substring(0, 2);
				//System.out.println(letter);
				switch(letter) {
				case "00":
					output += " ";
					break;
				case "27":
					output += ".";
					break;
				case "28":
					output += ",";
					break;
				case "29":
					output += "!";
					break;
				case "30":
					output += "?";
					break;
				default:
					output += whatLetter(letter);
					break;
				}
				letter = String.format("%04d", codes[l]).substring(2);
				//System.out.println(letter);
				switch(letter) {
				case "00":
					output += " ";
					break;
				case "27":
					output += ".";
					break;
				case "28":
					output += ",";
					break;
				case "29":
					output += "!";
					break;
				case "30":
					output += "?";
					break;
				default:
					output += whatLetter(letter);
					break;
				}
			}
			//System.out.println(key);
			System.out.println(output);
		}
	}

}
