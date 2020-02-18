package calculadora;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class BasicCalculator extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasicCalculator frame = new BasicCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BasicCalculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 296);
		contentPane = new JPanel();
		contentPane.setForeground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("Terminator Two", Font.PLAIN, 18));
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setFont(new Font("Terminator Two", Font.BOLD, 18));
		textField2.setColumns(10);
		
		JButton btnSumar = new JButton("ADD");
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float n1,n2,res;
				
				try {
					n1=Float.parseFloat(textField1.getText());
					n2=Float.parseFloat(textField2.getText());
					res=n1+n2;
					
					result.setText(Float.toString(res));
					
				}catch (Exception eAdd) {
					JOptionPane.showMessageDialog(null,"Invalid Option in Add");
				}
				
									
			}
		});
		
		JButton btnRestar = new JButton("SUBTRACT");
		btnRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float n1,n2,res;
				
				try {
					n1=Float.parseFloat(textField1.getText());
					n2=Float.parseFloat(textField2.getText());
					res=n1-n2;
					
					result.setText(Float.toString(res));
					
				}catch (Exception eAdd) {
					JOptionPane.showMessageDialog(null,"Invalid Option in Subtract");
				}
				
			}
		});
		
		JButton btnMultiplicar = new JButton("MULTIPLY");
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float n1,n2,res;
				
				try {
					n1=Float.parseFloat(textField1.getText());
					n2=Float.parseFloat(textField2.getText());
					res=n1*n2;
					
					result.setText(Float.toString(res));
					
				}catch (Exception eAdd) {
					JOptionPane.showMessageDialog(null,"Invalid Option in Multiply");
				}
				
			}
		});
		
		JButton btnDividir = new JButton("DIVIDE");
		btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				float n1,n2,res;
				
				try {
					n1=Float.parseFloat(textField1.getText());
					n2=Float.parseFloat(textField2.getText());
					res=n1/n2;
					
					result.setText(Float.toString(res));
					
				}catch (Exception eAdd) {
					JOptionPane.showMessageDialog(null,"Invalid Option in Division");
				}
				
			}
		});
		
		result = new JTextField();
		result.setFont(new Font("Terminator Two", Font.PLAIN, 16));
		result.setColumns(10);
		
		JLabel lblResult = new JLabel("RESULT");
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnNewButton = new JButton("RESTART");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField1.setText(null);
				textField2.setText(null);
				result.setText(null);
			}
		});
		
		JLabel lblCalculator = new JLabel("CALCULATOR");
		lblCalculator.setForeground(Color.RED);
		lblCalculator.setFont(new Font("Terminator Two", Font.BOLD, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnRestar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSumar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
							.addGap(28)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCalculator, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
								.addComponent(result, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnDividir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnMultiplicar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField2, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(182)
					.addComponent(lblResult)
					.addContainerGap(194, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
							.addGap(64))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCalculator, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(result, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblResult)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSumar)
								.addComponent(btnMultiplicar))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRestar)
								.addComponent(btnDividir)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(42)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addGap(17))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
