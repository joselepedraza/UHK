import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextReader {
	private String FileName;
	public TextReader(String name) {
		
		this.FileName=name;
	}
	public String ReadField() {		//Usar bufferwriter| todo a la vez
		String text = "";
		try {
			FileReader fr = new FileReader(FileName);
			BufferedReader bfr = new BufferedReader(fr);
			String s;
			
			while((s = bfr.readLine()) != null) {
				text += s + '\n';
			}
			fr.close();	
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return text;
	}
	public void WriteFile(String text){
		try{
			FileWriter fw = new FileWriter(FileName);
			fw.write(text);
			fw.flush();
			//BufferedWriter bfw = BufferedWriter();
			fw.close();
		} catch(IOException e){
			e.printStackTrace();
		}
		
		
	}
}
