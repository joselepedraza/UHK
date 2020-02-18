
import java.util.*;

public class Matrix {
	 private int[][] data;
	 
	 public Matrix(int nrows, int ncols) {
		 data = new int[nrows][ncols];
		 
	 }
	 
	 public int getData(int row, int col) {
		 return data[row][col];
	 }
	 
	 public void setData(int row, int col, int value) {
		 data[row][col] = value;
	 }
	 
	 public void fillRandom(int maxValue) {
		 Random rand = new Random();
			for(int i=0; i < data.length; i++) {	//row - fila
				for(int j=0; j < data[i].length; j++) { //colum 
					data[i][j] = rand.nextInt(maxValue);
				}
			}
	 }
	 
	 public void print() {
		 for(int i=0; i<data.length; i++) {//suma filas
				for(int j=0; j<data[i].length; j++) {
					System.out.print(data[i][j] + "\t");
				}
				System.out.println();
			}
	 }
	 
	 
	 
	 
	 
	 
}
