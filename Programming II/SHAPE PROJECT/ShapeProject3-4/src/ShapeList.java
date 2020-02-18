import java.awt.Graphics;
import java.util.ArrayList;

public class ShapeList {
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public void addShape(Shape s) {
		shapes.add(s);
		
	}
	
	public int calculateArea() {
		int sum = 0;
		for (Shape s : shapes) {
			sum += s.calculateArea();
		}
		return sum; 
	}

	public void draw(Graphics g) {	//creamos el metodo para pintar las figuras de dentro de la lista
		for(Shape shape : shapes) {
			shape.draw(g);
		}
		
	}
	
	
}
