import java.util.ArrayList;

public class Utility {
	/*
	 * public static void main(String[] args) { DecimalFormat df = new
	 * DecimalFormat("00.00"); System.out.println(df.format(4.509)); }
	 */

	static int indexOf(int[] array, int value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value)
				return i;
		}
		return -1;
	}

	static int indexOf(String[] array, String value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(value))
				return i;
		}
		return -1;
	}

	static int indexOf(double[] array, double value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value)
				return i;
		}
		return -1;
	}

	static boolean isPrime(int n) {
		if (n % 2 == 0)
			return false;
		int max = (int) Math.sqrt(n);
		for (int i = 3; i <= max; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	static ArrayList<Integer> getPrimeFactors(int n) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		while (n % 2 == 0) {
			factors.add(2);
			n /= 2;
		}
		for (int i = 3; i * i <= n; i += 2) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		if (n > 1)
			factors.add(n);
		return factors;
	}

	static ArrayList<Integer> getAllFactors(int n) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		int max = (int) Math.sqrt(n);
		for (int i = 1; i <= max; ++i) {
			if (n % i == 0) {
				factors.add(i);
				if (i != n / i) {
					factors.add(n / i);
				}
			}
		}
		return factors;
	}

	static char[][] getCharGrid(String[] lines) {
		char[][] grid = new char[lines[0].length()][lines.length];
		for (int j = 0; j < lines.length; j++) {
			for (int i = 0; i < lines[0].length(); i++) {
				grid[j][i] = lines[j].charAt(i);
			}
		}

		return grid;
	}

	static int[][] getIntGrid(String[] lines) {
		int[][] grid = new int[lines[0].length()][lines.length];
		for (int j = 0; j < lines.length; j++) {
			for (int i = 0; i < lines[0].length(); i++) {
				grid[j][i] = (int) (lines[j].charAt(i));
			}
		}

		return grid;
	}

	static int factorial(int num) {
		int sum = 1;
		for (int i = num; i > 1; i--) {
			sum *= i;
		}

		return sum;
	}

	static int greatestCommonDenominator(int a, int b) {
		if (b == 0)
			return a;
		else
			return greatestCommonDenominator(b, a % b);
	}

	static void bubbleSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length - 1; j++) {
				if (data[j] > data[j + 1]) {
					int tmp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = tmp;
				}
			}
		}
	}

	static int[] mergeSort(int[] data) {
		if (data.length == 1)
			return data;
		int middle = data.length / 2;
		int[] left = mergeSort(subArray(data, 0, middle - 1));
		int[] right = mergeSort(subArray(data, middle, data.length - 1));
		int[] result = new int[data.length];
		int dPtr = 0;
		int lPtr = 0;
		int rPtr = 0;
		while (dPtr < data.length) {
			if (lPtr == left.length) {
				result[dPtr] = right[rPtr];
				rPtr++;
			} else if (rPtr == right.length) {
				result[dPtr] = left[lPtr];
				lPtr++;
			} else if (left[lPtr] < right[rPtr]) {
				result[dPtr] = left[lPtr];
				lPtr++;
			} else {
				result[dPtr] = right[rPtr];
				rPtr++;
			}
			dPtr++;
		}
		return result;
	}

	static int[] subArray(int[] data, int start, int inclusiveEnd) {
		int[] sub = new int[inclusiveEnd - start + 1];
		for (int i = 0; i < inclusiveEnd - start + 1; i++) {
			sub[i] = data[start + i];
		}
		return sub;
	}
	
	static void quicksort(int arr[], int p, int q){
		if (p < q)
		{
			int r = partition(arr, p, q);
			quicksort(arr, p, r - 1);
			quicksort(arr, r + 1, q);
		}
	}

	private static int partition(int arr[], int p, int q){
		int x = arr[p];
		int i = p;
		for (int j = p + 1; j < q; j++)
		{
			if (arr[j] <= x)
			{
				i = i + 1;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		int tmp = arr[p];
		arr[p] = arr[i];
		arr[i] = tmp;
		return i;
	}


}
