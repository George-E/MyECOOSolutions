import java.io.*;
import java.util.*;

public class p2 {

	public static void main(String[] args) {
		try {
			BufferedReader in =  new BufferedReader(new FileReader("DATA22.txt"));//verify name BEFORE judging

			for (int test = 0; test < 10; test++) {// change to # test cases
				try {
					int n = Integer.parseInt(in.readLine());
					int[] s = new int [n];
					String[] r = in.readLine().split(" ");
					for(int i = 0; i < n; i++)
					{
						s[i] = Integer.parseInt(r[i]);
					}
					int[] t = new int [5];
					String str = in.readLine();
					r = str.split(" ");
					for(int i = 0; i < 5; i++)
					{
						t[i] = Integer.parseInt(r[i]);
					}
					Utility.quicksort(s, 0, s.length);
					ArrayList<Integer> sS = new ArrayList<Integer>();
					sS.add(s[0]);
					for(int i = 1; i < s.length; i++)
					{
						if(s[i] == s[i-1])
						{
							continue;
						}
						sS.add(s[i]);
					}
					s = new int[sS.size()];
					for(int i = 0; i < s.length; i++)
					{
						s[i] = sS.get(i);
					}
					
					boolean[] re = new boolean[5];
					for(int i = 0; i < s.length; i++)
					{
						for(int j = 0; j < s.length; j++)
						{
							for(int k = 0; k < s.length; k++)
							{
								for(int l = 0; l < 5; l++)
								{
									if(re[l])
									{
										continue;
									}
									if(t[l] - s[i] - s[j] - s[k] == 0)
									{
										re[l] = true;
										continue;
									}
									if(t[l] - s[i] - s[j] * s[k] == 0)
									{
										re[l] = true;
										continue;
									}
									if(t[l] - s[i] * s[j] * s[k] == 0)
									{
										re[l] = true;
										continue;
									}
									if(t[l] - s[i] * (s[j] + s[k]) == 0)
									{
										re[l] = true;
									}
								}
							}
						}
					}
					System.out.print(re[0] ? "T" : "F");
					System.out.print(re[1] ? "T" : "F");
					System.out.print(re[2] ? "T" : "F");
					System.out.print(re[3] ? "T" : "F");
					System.out.println(re[4] ? "T" : "F");
					
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


