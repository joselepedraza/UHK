import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextReader {
	private String filename;
	
	public TextReader(String filename) {
		this.filename = filename;
	}
	
	public String readFile() {
		String text = "";
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader bfr = new BufferedReader(fr);
			
			String s = ""; //creamos string (abrimos)
			while ((s = bfr.readLine() ) != null) {
				text += s; //añadimos al string
			}
			bfr.close(); //cerrramos string y mostramos lo guardado
			//System.out.print(text);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			text = "File cannot be openned";
		} catch (IOException e) {
			e.printStackTrace();
			text = "File cannot be openned";
		}
		return text;
	}
	
	public void writeFile(String text){
		try{
			FileWriter fw = new FileWriter(filename);
			fw.write(text);
			fw.flush();
			//BufferedWriter bfw = BufferedWriter();
			fw.close();
		} catch(IOException e){
			e.printStackTrace();
		}
		
		
	}
}
