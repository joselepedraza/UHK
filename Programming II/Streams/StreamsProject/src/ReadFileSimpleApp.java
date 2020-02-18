import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileSimpleApp {
	public static void main (String[] args) {
		try {
			FileReader fr = new FileReader("C:\\Users\\Josele\\Desktop\\ShapeProject2\\src\\pa//ping.txt");
			BufferedReader bfr = new BufferedReader(fr);
			
			//int i = fr.read();	//por si esta vacio (conveniente meterlo dentro del while)
			
			String text = "";
			String s = ""; //creamos string (abrimos)
			while ((s = bfr.readLine() ) != null) {
				text += s; //añadimos al string
			}
			bfr.close(); //cerrramos string y mostramos lo guardado
			System.out.print(text);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
