import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;

public class ClickApp extends JFrame implements ActionListener{

	private int clicks;
	private JLabel label = new JLabel("CLICKS: 0");
	
	public ClickApp() {
		setTitle("Click Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
	}
	
	private void initComponents() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(600, 200));
	
		
		panel.add(label,BorderLayout.CENTER);
		
		JButton button = new JButton("click");
		panel.add(button,BorderLayout.SOUTH);
		button.addActionListener(this);
		
		setContentPane(panel);
		pack();	
		
		
	}

	public static void main(String[] args) {

			new ClickApp().setVisible(true);
			
	}

	
	public void actionPerformed(ActionEvent e) {
		clicks++;
		label.setText("CLICKS: " + clicks);
	}

}
