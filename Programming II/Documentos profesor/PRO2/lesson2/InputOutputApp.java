import java.util.*;

public class InputOutputApp {

	public static void main(String[] args) {
		int[][] a = new int[4][3];
		
		Random rand = new Random();
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = rand.nextInt(100);
			}
			
		}
		
		
		int[] rowSums = new int[a.length];
		int[] colSums = new int[a[0].length];
		
		
		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = 0; j < a[i].length; j++) {
				sum += a[i][j];
			}
			rowSums[i] = sum;
		}
		
		for (int i = 0; i < a[0].length; i++) {
			int sum = 0;
			for (int j = 0; j < a.length; j++) {
				sum += a[j][i];
			}
			colSums[i] = sum;
		}


		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.print(rowSums[i]);
			System.out.println();
		}
		
		for (int i = 0; i < colSums.length; i++) {
			System.out.print(colSums[i]+"\t");
		}
		
	}

}
