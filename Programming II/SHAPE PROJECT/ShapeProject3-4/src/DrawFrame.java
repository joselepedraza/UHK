import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class DrawFrame extends JFrame implements ActionListener, MouseListener {
	private JPanel drawPanel;
	//private Rectangle rect;
	private ShapeList shapeList = new ShapeList();
	private Shape newShape;
	private JButton rectangle, triangle;

	public DrawFrame() { 
		setTitle("Draw application");	//establece el titulo de la ventanita
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setLayout(new BorderLayout());
		
		initToolbar();
		initDrawPanel();
		
		setSize(500, 400);	//poner despues de initToolbar para que "pack" se adapte bien a este tamaño
		
	}
	
	
	private void initDrawPanel() {
		drawPanel = new JPanel();	//con refactor sacamos Field (private JPanel drawPanel)
		drawPanel.addMouseListener(this);	//para capturar los clicks
		add(drawPanel, BorderLayout.CENTER); //insertamos panel en el centro
		
	}



	private void initToolbar() {
		JToolBar toolbar = new JToolBar(); //primero crear instancia y asignar id
		
		rectangle = new JButton("Rectangle");
		rectangle.addActionListener(this); //agregamos a la clase el "implements ActionListener"
		
		toolbar.add(rectangle);	//añadimos el boton a la barra de herramientas
		
		//getContentPane().setLayout(new BorderLayout());


		triangle = new JButton("Triangle");
		triangle.addActionListener(this); //agregamos a la clase el "implements ActionListener"
		
		toolbar.add(triangle);	//añadimos el boton a la barra de herramientas
		
		//getContentPane().setLayout(new BorderLayout());
		add(toolbar, BorderLayout.PAGE_START);	//añadimos toolbar al inicion del marco
		
		
		pack();	//empaquetar y asignar a Panel
	}

	@Override	//se agrega al añadir metodos sin definir (ActionListener)
	public void actionPerformed(ActionEvent e) {
		//Rectangle rect = new Rectangle(100, 100, 50, 70);
		//rect.draw(drawPanel.getGraphics());	//rec refactor to a Field
		//drawPanel.getGraphics().drawRect(100, 100, 50, 50);
		
		if(e.getActionCommand() == "Rectangle") {
			newShape = new Rectangle();	//refactor
			shapeList.addShape(newShape);	//las intancias las guardamos dentro de la lista de figuras(no hace falta tenerlo en fields)
		}
		else if(e.getActionCommand() == "Triangle") {
			newShape = new Triangle();	//refactor
			shapeList.addShape(newShape);
		}
		//Rectangle rect = new Shape(); NO PODEMOS CREAR UNA INSTANCIA DE UNA CLASE ABSTRACTA
	}
	
	public void paint(Graphics g) {	
		super.paint(g);
		/*
		if ( rect != null )
			rect.draw(g);
		*/
		shapeList.draw(drawPanel.getGraphics());//para que guarde la relacion de aspecto con el panel
	}
	


	public static void main(String[] args) {	//para mostrar debemos poner algo por aqui
		new DrawFrame().setVisible(true); //crear instancia y hacer visible
		

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		/*		
		if(newShape != null) {
			newShape.setX(e.getX());
			newShape.setY(e.getY());
			newShape.setWidth(100);
			newShape.setHeight(50);
			
			newShape.draw(drawPanel.getGraphics());
		}
		newShape = null;	//para que haya que darle al click cada vez que se quiera poner una figura
		*/
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
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
			newShape.draw(drawPanel.getGraphics());
			
		}
		
		newShape = null ;
			
		
	}



	
}
