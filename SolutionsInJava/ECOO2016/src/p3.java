import java.io.*;
import java.util.*;

public class p3 {

	public static void main(String[] args) {
		try {
			BufferedReader in =  new BufferedReader(new FileReader("DATA31.txt"));//verify name BEFORE judging

			for (int test = 0; test < 10; test++) {// change to # test cases
				try {
					int T = Integer.parseInt(in.readLine());
					
					String[] tokens = in.readLine().split(" ");
					int[] train = new int[T];
					
					for(int x = 0; x <T; x++){
						train[x] = Integer.parseInt(tokens[x]);
					}
					
					int[] sorted = train.clone();
					Arrays.sort(sorted);
					
					//System.out.println(Arrays.toString(sorted));//remove
					int cost=0;
					int firstMoved=-1;
					int lastPos = Utility.indexOf(train, sorted[sorted.length-1]);
					
					for (int i=T-2; i>=0;i--) {
						int temp = Utility.indexOf(train, sorted[i]);
						//System.out.println(sorted[i] + " at pos " + temp);//remove
						if (firstMoved==-1) {
							if (temp >lastPos) {
								firstMoved = sorted[i];
								cost+=temp;
								//System.out.println("added temp... " + temp);//remove
							}else {
								lastPos = temp;
							}
						} else  {
							cost+=temp;
							//System.out.println("added temp... " + temp);//remove
							int counter =0;
							//System.out.println(firstMoved);
							for (int y=temp+1;y<T;y++) {
							//	System.out.println(train[y]);
								if (train[y] <= firstMoved && train[y] > train[temp]) {
									counter++;
								}
							}
							//System.out.println(counter);
							cost+=counter;
							//System.out.println("added counter... " + counter);//remove
						}
					}
					
					System.out.println(cost);

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


