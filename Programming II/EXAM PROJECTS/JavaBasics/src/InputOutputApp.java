import java.util.*;

public class InputOutputApp {

	public static void main(String[] args) {
		
		int a[][] = new int[10][5];
		
		Random rand = new Random();
		for(int r=0; r < a.length; r++) {	//row - fila
			for(int c=0; c < a[r].length; c++) { //colum 
				a[r][c] = rand.nextInt(100);
			}
		}
		
		int[] rowSums = new int[a.length];
		int[] colSums = new int[a[0].length];
		
		for(int i=0; i<a.length; i++) {//suma filas
			int suma = 0;
			for(int j=0; j<a[i].length; j++) {
				suma = suma + a[i][j];
			}
			rowSums[i] = suma;
		}
		
		for(int i=0; i<a[0].length; i++) {//suma columnas
			int suma = 0;
			for(int j=0; j<a.length; j++) {
				suma = suma + a[j][i];
			}
			colSums[i] = suma;
		}
		
		for(int i=0; i<a.length; i++) {	//mostrar debajo de las filas
			for(int j=0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
				//rowSum[i] += a[i][j];
				//colSum[i] += a[j][i];
			}
			System.out.print(rowSums[i]);
			System.out.println();	
		}
		
		for(int i=0; i<colSums.length; i++) {	//mostrar al lado de la columna
			System.out.print(colSums[i] + "\t");
		}

		/*segundo ejemplo
		int a[] = new int[10];
		
		Random rand = new Random();
		for(int i=0; i<a.length; i++) {
			a[i] = rand.nextInt(100);
		}
		
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	    */
		
		/*primer ejemplo
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		
		System.out.print("Input value was " + a);
		*/
	}

}
