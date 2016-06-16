import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class preCalcDistances {

	public static void main(String[] args) throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(new File("DIST.txt")));
		double test[][] = new double[401][401];
		//System.out.println("double dist[][] = {");
		out.write("double dist[][] = {\n");
		for (int x=0; x<=400;x++) {
			for (int y=0; y<=400;y++) {
				test[x][y] = Math.sqrt(x*x + y*y);
			}
			String line = Arrays.toString(test[x]);
			line = line.substring(1,line.length()-1);
			out.write("{" + line + "}" + ((x==400)?"":",") + "\n");
		}
		out.write("};\n");
		out.close();
	}

}
