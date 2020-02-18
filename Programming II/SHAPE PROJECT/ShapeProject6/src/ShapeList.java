import java.awt.Graphics;
import java.util.ArrayList;

public class ShapeList {

	private ArrayList<Shape> shapes = new ArrayList<Shape>() ;
	
	public void addShape(Shape s) {
		shapes.add(s) ;
	}
	
	public int calculateArea() {
		int sum = 0 ;
		
		for(Shape s : shapes) {
			sum += s.calculateArea() ;
		}
		return sum ;
	}

	public void draw(Graphics g) {
		
		for(Shape shape : shapes) {
			shape.draw(g);
		}
		
	}
	
	public void move(int deltaX, int deltaY, int drawAreaWeidth, int drawAreaHeight) {
		
		for(Shape shape : shapes) {
			if((shape.getX() - deltaX) < 0) shape.changeXDirection();
			if((shape.getX() + shape.getWidth() + deltaX) > drawAreaWeidth) shape.changeXDirection();
			if((shape.getY() - deltaY) < 0) shape.changeYDirection();
			if((shape.getY() + shape.getHeight() + deltaY) > drawAreaHeight) shape.changeYDirection();
			
			shape.move(deltaX, deltaY);
		}
		
	}
}
