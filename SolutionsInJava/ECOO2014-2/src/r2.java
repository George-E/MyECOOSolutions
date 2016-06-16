import java.io.*;
import java.util.*;

public class r2 {

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File("DATA21.txt"));
			for (int i = 0; i < 10; i++) {// change to 10
				int size = in.nextInt();
				int[][] pos = new int[5][2];
				for (int t = 0; t < 5; t++) {
					pos[t][0] = in.nextInt()-1;
					pos[t][1] = in.nextInt()-1;
				}
				boolean[] masterGrid = new boolean[5];
				List<Integer> factors = new ArrayList<Integer>();
				for (int m = 1; m <= size; m++) {
					if (size % m == 0)
						factors.add(m);
				}
				for (int l : factors) {
					boolean[] tempGrid = new boolean[5];

					for (int r = 0; r < 5; r++) {
						int tempR = pos[r][0];
						int tempC = pos[r][1];
						while (tempR % l != 0 && tempR != 1) {
							tempR--;
						}
						while (tempC % l != 0 && tempC != 1) {
							tempC--;
						}
						if (((tempR  / l) % 2 == 0)
								&& ((tempC  / l) % 2 == 0))
							tempGrid[r] = true;
						else if (((tempR  / l) % 2 != 0)
								&& ((tempC  / l) % 2 != 0))
							tempGrid[r] = true;
					}
					/*
					System.out.println(l + "\n");
					for (int y = 0; y < size; y++) {
						for (int h = 0; h < size; h++) {
							if (tempGrid[y][h])
								System.out.print('x');
							else
								System.out.print('o');
						}
						System.out.println();
					}
					System.out.println();
					*/
					for (int r = 0; r < 5; r++) {
						if (tempGrid[r]) {
							if (masterGrid[r])
								masterGrid[r] = false;
							else
								masterGrid[r] = true;
						}
					}
					/*
					for (int y = 0; y < size; y++) {
						for (int h = 0; h < size; h++) {
							if (masterGrid[y][h])
								System.out.print('x');
							else
								System.out.print('o');
						}
						System.out.println();
					}
					System.out.println();
					*/
				}

				String output = "";

				for (int r = 0; r < 5; r++) {
					if (masterGrid[r])
						output += 'B';
					else
						output += 'G';
				}
				System.out.println(output);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
