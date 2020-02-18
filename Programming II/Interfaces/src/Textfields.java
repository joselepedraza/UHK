import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Textfields extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JLabel label = new JLabel("");
	private String inText = "";
	
	private JTextField text = new JTextField();
	
	public Textfields() {
		setTitle("Text field frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
	}
	private void initComponents() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(600, 200));
	
		
		panel.add(label,BorderLayout.CENTER);
		
		JButton button = new JButton("erase");
		panel.add(button,BorderLayout.NORTH);
		button.addActionListener(this);
		
		panel.add(text,BorderLayout.SOUTH);
		text.addActionListener(this);
		
		
		setContentPane(panel);
		pack();	
	}
	public static void main(String[] args) {
		
		new Textfields().setVisible(true);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(!command.equals("erase")) {
			inText += ' ';
			inText += e.getActionCommand();
			label.setText(inText);
			text.setText("");
		}else {
			label.setText("");
			inText = "";
		}
	}

}
