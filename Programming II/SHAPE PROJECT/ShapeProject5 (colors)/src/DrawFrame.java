import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class DrawFrame extends JFrame implements ActionListener, MouseListener {
	private JPanel drawPanel;
	private ShapeList shapeList = new ShapeList();
	private Shape newShape;
	
	private Color currBorderColor = Color.black;
	
	public Color getCurrBoderColor() {
		return currBorderColor;
	}
	public void setCurrBorderColor(Color currBorderColor) {
		if (currBorderColor != null) {
			this.currBorderColor = currBorderColor;
		}
	}

	public DrawFrame() { 
		setTitle("Draw application");	//establece el titulo de la ventanita
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setLayout(new BorderLayout());
		
		initToolbar();	//inicializamos la barra de herramientas
		initDrawPanel();	
		//si no va despues de la inicializacion la ventana modificará su tamaño
		setSize(500, 400);	//poner despues de initToolbar para que "pack" se adapte bien a este tamaño
	}
	
	private void initDrawPanel() {
		drawPanel = new JPanel();	//con refactor sacamos Field (private JPanel drawPanel)
		drawPanel.addMouseListener(this);	//para capturar los clicks
		add(drawPanel, BorderLayout.CENTER); //insertamos panel en el centro de la ventana
	}



	private void initToolbar() {
		JToolBar toolbar = new JToolBar(); //primero crear instancia de la barra de tareas y asignar id
		
		//BOTON RECTANGULO
		JButton button = new JButton("Rectangle");	//Creamos botón
		button.setIcon(new ImageIcon("rectangle.png","")); //para asignar icono al botón
		button.addActionListener(new ActionListener() {	//clase anonima (acción de clicar el boton)
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newShape = new Rectangle();
				newShape.setBorderColor(currBorderColor);
				shapeList.addShape(newShape);		
			}
		});//aniadimos el listener
		toolbar.add(button);	//insertamos boton en barra
		
		//BOTÓN ELIPSE
		button = new JButton("Elipse");
		button.setIcon(new ImageIcon("elipse.png","")); 
		button.addActionListener(new ActionListener() {	//clase anonima
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newShape = new Elipse();
				newShape.setBorderColor(currBorderColor);
				shapeList.addShape(newShape);		
			}
		});
		toolbar.add(button);
		
		//BOTON TRIANGLE
		button = new JButton("Triangle");
		button.setIcon(new ImageIcon("triangle.png","")); 
		button.addActionListener(new ActionListener() {	//clase anonima
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newShape = new Triangle();
				newShape.setBorderColor(currBorderColor);
				shapeList.addShape(newShape);		
			}
		});
		toolbar.add(button);
		
		//BOTON COLOR
		button = new JButton("COLOR"); 
		button.setIcon(new ImageIcon("color.png","")); 
		button.addActionListener(new ActionListener() {	//clase anonima

			@Override
			public void actionPerformed(ActionEvent e) {
				setCurrBorderColor(JColorChooser.showDialog(null, "Choose color", currBorderColor));
			}
			
			
		});
		toolbar.add(button);	
		
		//BOTON PARA DAR MOVIMIENTO
		button = new JButton("MOVE");
		button.setIcon(new ImageIcon("move.png","")); 
		button.addActionListener(getMoveListener());
		toolbar.add(button);
		
		//BOTON PARA CARGAR DESDE ARCHIVO
		button = new JButton("Load");
		button.addActionListener(load());
		toolbar.add(button);
		
		//BOTON PARA GUARDAR EN ARCHIVO
		button = new JButton("Save");
		//button.setIcon(new ImageIcon("",""));
		button.addActionListener(save());
		toolbar.add(button);
		
		
	
		
		
		
		//setLayout(new BorderLayout());	//situa el boton en la ventana(creo que no hace falta)
		add(toolbar, BorderLayout.PAGE_START);	//añadimos toolbar al inicio del marco
		
		pack();	//empaquetar y asignar a Panel (lo empaqueta en el main por asi decirlo)
	}

	@Override	//se agrega al añadir metodos sin definir (ActionListener)
	public void actionPerformed(ActionEvent e) {//lo coge de los hijos
		/*
		//if(e.getSource() == btnRectangle)
		newShape = new NewRectangle();
		shapeList.addShape(newShape); //Añadimos el rectangulo a la lista para dibujar varios
		Shape rect = new NewRectangle() ;
		*/
		
		//Rectangle rect = new Rectangle(100, 100, 50, 70);
		//rect.draw(drawPanel.getGraphics());	//rec refactor to a Field
		//drawPanel.getGraphics().drawRect(100, 100, 50, 50);
		
		/*	
		se puede hacer con getSource
		if(e.getActionCommand() == "Rectangle") {
			newShape = new Rectangle();	//refactor
			shapeList.addShape(newShape);	//las intancias las guardamos dentro de la lista de figuras(no hace falta tenerlo en fields)
		}
		else if(e.getActionCommand() == "Triangle") {
			newShape = new Triangle();	//refactor
			shapeList.addShape(newShape);
		}
	*/	
		//Rectangle rect = new Shape(); NO PODEMOS CREAR UNA INSTANCIA DE UNA CLASE ABSTRACTA
	}
	
	//Generar movimiento (cuanto mas se pulse mas rapido se mueve)
	private ActionListener getMoveListener(){
		return new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				Timer timer = new Timer();
				MoveTask moving = new MoveTask(shapeList,drawPanel); //guardamos lo que queremos mover
				timer.schedule(moving, 10 ,500);	//da movimiento a la lista de objetos creados
				/*shapeList.move(10, 10,drawPanel.getWidth(),drawPanel.getHeight());
				update(getGraphics());
				shapeList.draw(drawPanel.getGraphics());*/
			}
		};
	}
	
	//Para guardar en archivo
	private ActionListener save(){
		return new ActionListener(){
			public void actionPerformed(ActionEvent e){
				saveshapes()	;
			}
		};
	}
	public void saveshapes(){
		String filename = "shapes.dat";
		ObjectOutputStream out;
		try{
			out = new ObjectOutputStream(new FileOutputStream(filename));
			shapeList.saveToStream(out);
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//Para cargar desde archivo
	private ActionListener load(){
		return new ActionListener(){
			public void actionPerformed(ActionEvent e){
				loadshapes();
			}
		};
	}
	public void loadshapes(){
		String filename = "shapes.dat";
		ObjectInputStream in;
		try{
			in = new ObjectInputStream(new FileInputStream(filename));
			shapeList.loadToStream(in);	//crear metodo en ShapeList para controlar excepciones
			in.close();
			shapeList.draw(drawPanel.getGraphics());
			
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public void paint(Graphics g) {	
		super.paint(g);
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
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {//pillamos el primer punto
		if(newShape != null) {	
			newShape.setX(e.getX());
			newShape.setY(e.getY());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int width, height ;
		if(newShape != null) {	//pillamos segundo punto y calculamos orientacion
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



	
}
