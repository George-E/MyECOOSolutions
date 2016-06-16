import java.io.*;
import java.util.*;

public class r1 {
	static int trueMass;
	static int count;

	static void split(int[] masses, int mass, int zero) {
		//System.out.println();
		//System.out.println(zero);
		if (zero != masses.length - 1)
			for (int i = 1; i <= mass-(masses.length-1-zero); i++) {
				if (zero > 0) {
					if (i > masses[zero-1])
					continue;
				}
				masses[zero] = i;
				//for (int o = 0; o < masses.length; o++) {
					//System.out.print(masses[o]+ " ");
				//}
				//System.out.println();
				split(masses, mass-i, zero +1);
			}
		else {
			if (mass > masses[zero-1])
				return;
			masses[zero] = mass;
			check(masses);
		}
	}

	static void check(int[] masses) {
		if (masses.length > 1){
			int[] newMasses = new int[masses.length-1];
			for (int i = 0; i<masses.length;i++) {
				for (int n = 0; n<masses.length-1;n++) {
					if (n<i)
					newMasses[n] = masses[i];
					else
					newMasses[n] = masses[i+1];
				}
				check(newMasses);
			}
		}
		boolean[] weights = new boolean[trueMass];
		int ls = 0;
		int rs = 0;
		for (int i = 0; i<masses.length;i++) {
			
		}
		if (Math.abs(ls-rs) <= trueMass && Math.abs(ls-rs) > 0)
			weights[Math.abs(ls-rs)-1] = true;
	}

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File("DATA40.txt"));
			for (int i = 0; i < 1; i++) {
				int pieces = in.nextInt();
				trueMass = in.nextInt();
				count = 0;
				int[] masses = new int[pieces];
				split(masses, trueMass, 0);
				System.out.println(count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
