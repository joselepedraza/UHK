import java.awt.Dimension;
import javax.swing.JFrame;

public class TestFrameApp {

	
	
	public static void main(String[] args) {
		//El nombre entre comillas da el nombre
		JFrame f = new JFrame("First window");

		//Hace que se cierre el programa cuando se cierre el run
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Tamano predefinido
		f.setSize(new Dimension(400,400));
		f.setVisible(true);	//Esto crea una ventana y la hace visible
		
		
	}

}
