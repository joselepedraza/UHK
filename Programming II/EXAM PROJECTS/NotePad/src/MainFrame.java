import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class MainFrame extends JFrame {
	
	public MainFrame() {
		setTitle("Java NotePad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init();
		setSize(1000,500);
	}
	
	private JTextArea text;
	private String file;
	
	private void init() {
		
		JToolBar toolbar = new JToolBar() ;
		
		
		
		JButton button = new JButton("Open") ;
		button.addActionListener(openIt()); 
		toolbar.add(button);
		
		button = new JButton("Save");
		button.addActionListener(writeIt()); 
		toolbar.add(button);
		
		setLayout(new BorderLayout()) ;
		add(toolbar, BorderLayout.PAGE_START) ; 

		pack();
		
		text = new JTextArea();
		add(text, BorderLayout.CENTER);	
	}
	
	private ActionListener openIt() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(null);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	openFile(chooser.getSelectedFile().getAbsolutePath());
			    }
			}
		};
	}
	private ActionListener writeIt(){
		return new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (file != null){
					writeFile(file);
				}else{
					JFileChooser chooser = new JFileChooser();
					chooser.showSaveDialog(null);
					file = chooser.getSelectedFile().getPath();
					writeFile(file);
					
				}
			}
		};
	}
	
	protected void openFile(String name) {//deberia estar implementado en clase a parte
		text.setText(new TextReader(name).readFile());		
	}
	
	protected void writeFile(String name){
		new TextReader(name).writeFile(text.getText());
	}


	
	
	public static void main(String[] args) {
		new MainFrame().setVisible(true);
	}

}
