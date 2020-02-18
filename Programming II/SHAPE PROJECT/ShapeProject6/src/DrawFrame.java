import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class DrawFrame extends JFrame implements ActionListener, MouseListener{
	
	private JPanel drawPanel;
	private ShapeList shapeList = new ShapeList();
	private Shape newShape;
	
	private Color currBorderColor = Color.BLACK;
	
	public Color getCurrBoderColor() {
		return currBorderColor;
	}
	
	public void setCurrBorderColor(Color currBorderColor) {
		if(currBorderColor != null) this.currBorderColor = currBorderColor;
	}

	public DrawFrame() {
		setTitle("Draw application") ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; //Establecemos la operacion por defecto para cuando cierre la ventana, si no lo ponemos se cierra la ventana pero sigue corriendo el programa
	
		initToolBar() ; //Inicializamos la barra de herramientas 
		initDrawPanel() ;
		setSize(1000,700) ; //Establecemos el tamaño de la ventana, si no va despues de initToolBar() la ventana modificará su tamaño	
	}

		
	private void initDrawPanel() {
		drawPanel = new JPanel();
		drawPanel.addMouseListener(this);
		add(drawPanel, BorderLayout.CENTER) ; //Añadimos el JPanel a la ventana situandolo en el centro
		
	}


	private void initToolBar() {
		JToolBar toolbar = new JToolBar() ; //Crea la instancia de la barra de tareas
		
		JButton button = new JButton() ; //Creamos un boton
		button.setIcon(new ImageIcon("rectangle-icon.png", ""));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				newShape = new NewRectangle();
				newShape.setBorderColor(currBorderColor);
				shapeList.addShape(newShape); //Aniadimos el rectangulo a la lista para dibujar varios
				
			}
		}); //A�adimos el listener
		
		toolbar.add(button) ; //Ponemos el boton en la barra de tareas
		
		button = new JButton() ; //Creamos un boton
		button.setIcon(new ImageIcon("Ellipse-tool-icon.png", ""));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				newShape = new Elipse();
				newShape.setBorderColor(currBorderColor);
				shapeList.addShape(newShape); //Aniadimos el rectangulo a la lista para dibujar varios
				
			}
		}); //A�adimos el listener
		
		
		toolbar.add(button) ; //Ponemos el boton en la barra de tareas
		
		button = new JButton() ; //Creamos un boton
		button.setIcon(new ImageIcon("triangle-icon.png", ""));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				newShape = new Triangle();
				newShape.setBorderColor(currBorderColor);
				shapeList.addShape(newShape); //Aniadimos el rectangulo a la lista para dibujar varios
				
			}
		}); //A�adimos el listener
		
		toolbar.add(button) ; //Ponemos el boton en la barra de tareas
		
		button = new JButton();
		button.setIcon(new ImageIcon("Color-Meter-icon.png", ""));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setCurrBorderColor(JColorChooser.showDialog(null,
						"Choose color", currBorderColor));
				
			}
		});
		
		toolbar.add(button) ; //Ponemos el boton en la barra de tareas
		
		button = new JButton();
		button.setIcon(new ImageIcon("move-icon.png", ""));
		button.addActionListener(getMoveListener());
		
		toolbar.add(button) ; //Ponemos el boton en la barra de tareas
		
		setLayout(new BorderLayout()) ; // Situamos el boton en la ventana 
		add(toolbar, BorderLayout.PAGE_START) ; //Aniadimos a la ventana la barra de tareas
		
		pack() ; //Como que empaqueta todo y lo mete en el main
		
	}
	
	private ActionListener getMoveListener() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Timer timer = new Timer();
				MoveTask moveTask = new MoveTask(shapeList, drawPanel);
				timer.schedule(moveTask, 10, 500);
			}
		};
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//if(e.getSource() == btnRectangle)
		
		
		newShape = new NewRectangle();
		shapeList.addShape(newShape); //Añadimos el rectangulo a la lista para dibujar varios
	
		Shape rect = new NewRectangle() ;
		
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	/*	if (newShape != null) {
			newShape.setX(e.getX());
			newShape.setY(e.getY());
			newShape.setWidth(100);
			newShape.setHeight(50);
			
			newShape.draw(drawPanel.getGraphics()); //Llamamos a dibujar
		}
		
		newShape = null ;*/
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		if(newShape != null) {
			newShape.setX(e.getX());
			newShape.setY(e.getY());
		}
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		int width, height ;
		if(newShape != null) {
			if(e.getX() > newShape.getX() && e.getY() > newShape.getY()) {
				width = e.getX() - newShape.getX() ; 
				height = e.getY() - newShape.getY();
				newShape.setWidth(width);
				newShape.setHeight(height) ;
			}else if(e.getX() < newShape.getX() && e.getY() < newShape.getY()){
				width = newShape.getX() - e.getX() ;
				height =newShape.getY() - e.getY() ;
				
				newShape.setX(e.getX());
				newShape.setY(e.getY());
				
				newShape.setWidth(width);
				newShape.setHeight(height) ;
			}else if(e.getX() > newShape.getX() && e.getY() < newShape.getY()){
				width = e.getX() - newShape.getX() ; 
				height =newShape.getY() - e.getY() ;
				
				newShape.setY(e.getY());
				
				newShape.setWidth(width);
				newShape.setHeight(height) ;
			}else if(e.getX() < newShape.getX() && e.getY() > newShape.getY()){
				width = newShape.getX() - e.getX() ;
				height = e.getY() - newShape.getY();
				
				newShape.setX(e.getX());
				
				newShape.setWidth(width);
				newShape.setHeight(height) ;
			}
			newShape.doDraw(drawPanel.getGraphics());
			
		}
		
		newShape = null ;
	}
	public void paint(Graphics g) {
		super.paint(g);
		
		shapeList.draw(drawPanel.getGraphics()) ;
	}

	public static void main(String[] args) {
		new DrawFrame().setVisible(true);
		

	}






}
