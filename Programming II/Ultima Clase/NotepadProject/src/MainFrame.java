import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class MainFrame extends JFrame {

	public MainFrame() {
		setTitle("Java Notepad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
		setSize(1000,700) ;
	}
	private JTextArea text;
	private String file;
	
	private void init() {
		
		JToolBar toolbar = new JToolBar() ; 
		
		JButton button = new JButton("Open") ; //Creamos un boton
		button.addActionListener(openit());
		toolbar.add(button);
		
		button = new JButton("Save");
		button.addActionListener(writeit());
		toolbar.add(button);

		setLayout(new BorderLayout()) ; // Situamos el boton en la ventana 
		add(toolbar, BorderLayout.PAGE_START) ; //Aniadimos a la ventana la barra de tareas
		
		pack() ; //Como que empaqueta todo y lo mete en el main
		
		text = new JTextArea();
		add(text, BorderLayout.CENTER) ;
	}
	
	private ActionListener openit() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
					
				    JFileChooser chooser = new JFileChooser();

				    int returnVal = chooser.showOpenDialog(null);
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				    	file=chooser.getSelectedFile().getPath();
				        openfile(file);
				    }
					
			}	
					
		};
	}
	private ActionListener writeit(){
		return new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (file != null){
					writefile(file);
				}else{
					JFileChooser chooser = new JFileChooser();
					chooser.showSaveDialog(null);
					file = chooser.getSelectedFile().getPath();
					writefile(file);
					
				}
			}
		};
	}
	protected void openfile(String name) { // Esto debería estar implementado en una clase aparte
		text.setText(new TextReader(name).ReadField());
	}
	protected void writefile(String name){
		new TextReader(name).WriteFile(text.getText());
	}
		
	

	public static void main(String[] args) {
		new MainFrame().setVisible(true);

	}

}
