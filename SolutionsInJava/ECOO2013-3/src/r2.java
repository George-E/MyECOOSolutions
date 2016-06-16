import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class r2 {

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File("DATA20.txt"));
			for (int i = 0; i < 10; i++) {
				String[] parents = {in.nextLine(),in.nextLine()};
				String child = in.nextLine();
				List<Integer> start = new ArrayList<Integer>();
				List<Integer> end = new ArrayList<Integer>();
				for (int n = 1; n<parents[0].length()-2; n++) {
					for (int u = n+1; u<parents[0].length()-1; u++) {
						start.add(n);
						end.add(u);
					}
				}
				//for (int n: start) {
				//	System.out.println(n);
				//}
				int mutations = -1;
				String trueIndex = null;
				for (int n = 0; n < start.size(); n++) {
					int tempMutations =  0;
					int tempMutations2 =  0;
					String index = start.get(n) + " " + end.get(n);
					for (int u = 0; u<parents[0].length(); u++) {
						if (u<start.get(n) || u>end.get(n) ) {
							if (child.charAt(u) != parents[0].charAt(u)) {
								tempMutations++;
							}
						} else {
							if (child.charAt(u) != parents[1].charAt(u)) {
								tempMutations++;
							}
						}
					}
					for (int u = 0; u<parents[0].length(); u++) {
						if (u<start.get(n) || u>end.get(n) ) {
							if (child.charAt(u) != parents[1].charAt(u)) {
								tempMutations2++;
							}
						} else {
							if (child.charAt(u) != parents[0].charAt(u)) {
								tempMutations2++;
							}
						}
					}
					if (mutations == -1) {
						trueIndex = index;
						if (tempMutations2 > tempMutations) 
						mutations = tempMutations;
						else
						mutations = tempMutations2;	
					}else {
						//System.out.print(mutations + " ");
						//System.out.print(tempMutations + " ");
						//System.out.print(tempMutations2 + " ");
						if (mutations > tempMutations) {
							mutations = tempMutations;
							trueIndex = index;
						}
						if (mutations > tempMutations2) {
							mutations = tempMutations2;
							trueIndex = index;
						}

						//System.out.println(mutations);
					}
				}
				DecimalFormat df = new DecimalFormat("0.00");
				System.out.println(df.format((double)mutations/parents[0].length()));
				//System.out.println(trueIndex);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
