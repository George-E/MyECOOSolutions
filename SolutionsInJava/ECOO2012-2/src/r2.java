import java.util.*;
import java.io.*;

public class r2
{
	public static void main(String[] args)
	{
		try
		{
			Scanner in = new Scanner(new File("DATA20.txt"));
			for (int n = 0; n<3; n++) {
				String pass = in.next();
				int points = 0;
				int len = pass.length();
				int dig = 0;
				int big = 0;
				int small = 0;
				int sym = 0;
				int consecSmall = 0;
				int consecBig = 0;
				int consecDig = 0;
				int consecSmallMax = 0;
				int consecBigMax = 0;
				int consecDigMax = 0;
				int consecSmallTot = 0;
				int consecBigTot = 0;
				int consecDigTot = 0;
				int seqLetPos = 0;
				int seqDigPos = 0;
				char seqLet = '!';
				int seqLetNum = 0;
				int seqLetNumMax = 0;
				char seqDig = '!';
				int seqDigNum = 0;
				int seqDigNumMax = 0;
				for (int i = 0; i < pass.length(); i++) {
					if (pass.substring(i,i+1).matches("[a-z]")) {
						small++;
						if (seqLet +1 == pass.charAt(i) && (seqLetPos == 1|| seqLetPos == 0)) {
							seqLetNum++;
							seqLetPos = 1;
						}
						else if (seqLet -1 == pass.charAt(i) && (seqLetPos == 2|| seqLetPos == 0)) {
							seqLetNum++;
							seqLetPos = 2;
						}
						else {
							if (seqLetNum > seqLetNumMax)
								seqLetNumMax = seqLetNum;
							seqLetNum = 1;
							seqLetPos = 0;
						}
						seqLet = pass.charAt(i);
						seqDig = '!';
						if (seqDigNum > seqDigNumMax)
							seqDigNumMax = seqDigNum;
						seqDigNum = 0;
						consecSmall++;
						if (consecDig > 1) {
							consecDigMax++;
							consecDigTot+= consecDig;
						}
						consecDig = 0;
						if (consecBig > 1){
							consecBigMax++;
							consecBigTot+= consecBig;
						}
						consecBig = 0;
						seqDigPos = 0;
					}
					else if (pass.substring(i,i+1).matches("[A-Z]")) {
						big++;
						if (seqLet +1 == pass.charAt(i) && (seqLetPos == 1|| seqLetPos == 0)) {
							seqLetNum++;
							seqLetPos = 1;
						}
						else if (seqLet -1 == pass.charAt(i) && (seqLetPos == 2|| seqLetPos == 0)) {
							seqLetNum++;
							seqLetPos = 2;
						}
						else {
							if (seqLetNum > seqLetNumMax)
								seqLetNumMax = seqLetNum;
							seqLetNum = 1;
							seqLetPos = 0;
						}
						seqLet = pass.charAt(i);
						seqDig = '!';
						if (seqDigNum > seqDigNumMax)
							seqDigNumMax = seqDigNum;
						seqDigNum = 0;
						consecBig++;
						if (consecDig > 1) {
							consecDigMax++;
							consecDigTot+= consecDig;
						}
						consecDig = 0;
						if (consecSmall > 1) {
							consecSmallMax ++;
							consecSmallTot+= consecSmall;
						}
						consecSmall = 0;
						seqDigPos = 0;
					}
					else if (pass.substring(i,i+1).matches("[0-9]")) {
						dig++;
						if (seqDig +1 == pass.charAt(i) && (seqDigPos == 1|| seqDigPos == 0)) {
							seqDigNum++;
							seqDigPos = 1;
						}
						else if (seqDig -1 == pass.charAt(i) && (seqDigPos == 2|| seqDigPos == 0)) {
							seqDigNum++;
							seqDigPos = 2;
						}
						else {
							if (seqDigNum > seqDigNumMax)
								seqDigNumMax = seqDigNum;
							seqDigNum = 1;
							seqDigPos = 0;
						}
						seqDig = pass.charAt(i);
						seqLet = '!';
						if (seqLetNum > 1)
							seqLetNumMax ++;
						seqDigNum = 0;
						consecDig++;
						if (consecBig > 1){
							consecBigMax++;
							consecBigTot+= consecBig;
						}
						consecBig = 0;
						if (consecSmall > 1) {
							consecSmallMax ++;
							consecSmallTot+= consecSmall;
						}
						consecSmall = 0;
						seqLetPos = 0;
					}
					else {
						sym++;
						seqDig = '!';
						if (seqDigNum > seqDigNumMax)
							seqDigNumMax = seqDigNum;
						seqLetNum = 0;
						seqLet = '!';
						if (seqLetNum > seqLetNumMax)
							seqLetNumMax = seqLetNum;
						seqLetNum = 0;
						if (consecDig > 1) {
							consecDigMax++;
							consecDigTot+= consecDig;
						}
						consecDig = 0;
						if (consecBig > 1){
							consecBigMax++;
							consecBigTot+= consecBig;
						}
						consecBig = 0;
						if (consecSmall > 1) {
							consecSmallMax ++;
							consecSmallTot+= consecSmall;
						}
						consecSmall = 0;
						seqDigPos = 0;
						seqLetPos = 0;
					}
				}
				if (consecSmall > 1) {
					consecSmallMax ++;
					consecSmallTot+= consecSmall;
				}
				if (consecBig > 1){
					consecBigMax++;
					consecBigTot+= consecBig;
				}
				if (consecDig > 1) {
					consecDigMax++;
					consecDigTot+= consecDig;
				}
				if (seqDigNum > seqDigNumMax)
					seqDigNumMax = seqDigNum;
				if (seqLetNum > seqLetNumMax)
					seqLetNumMax = seqLetNum;
				///System.out.println(consecSmallTot + " " + consecSmallMax);
				//System.out.println(consecBigTot + " " + consecBigMax);
				//System.out.println(consecDigTot + " " + consecDigMax);
				//System.out.println(seqLetNumMax + " " + seqDigNumMax);
				points += len*4; //
				int tempPoints = 0;
				if (big > 0) tempPoints += 2;
				if (small > 0) tempPoints += 2;
				if (dig > 0) tempPoints += 2;
				if (sym > 0) tempPoints += 2;
				if (tempPoints > 5 && len > 7) points += tempPoints +2; //
				if (big > 0)
				points += (len-big) *2;
				if (small > 0)
				points += (len-small) *2;
				if (dig< len)
				points += 4*dig;
				points += 6*sym;
				int minus = 0;
				if (pass.substring(0,1).matches("[0-9]") || pass.substring(0,1).matches("[^0-9,a-z,A-Z]")) {
					minus++;
				}
				if (pass.substring(len-1).matches("[0-9]") || pass.substring(len-1).matches("[^0-9,a-z,A-Z]")) {
					minus++;
				}
				points += 2 * (dig + sym - minus);
				if (dig + sym ==0) {
					points -= len;
				}
				if (small + big + sym ==0) {
					points -= len;
				}
				points -= 2 *(consecBigTot - consecBigMax);
				points -= 2 *(consecSmallTot - consecSmallMax);
				points -= 2 *(consecDigTot - consecDigMax);
				if (seqDigNumMax > 2) {
					points -= 3 * (seqDigNumMax-2);
				}
				if (seqLetNumMax > 2) {
					points -= 3 * (seqLetNumMax-2);
				}
				if (points >100)
					points = 100;
				if (points <0)
					points = 0;
				String output = "";
				if (points <= 20)
					output = "Very Weak";
				else if (points <= 40)
					output = "Weak";
				else if (points <= 60)
					output = "Good";
				else if (points <= 80)
					output = "Strong";
				else 
					output = "Very Strong";
				System.out.println(output + " (score =  " + points +")");
			}
		}
	catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
