import java.awt.Graphics;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ShapeList implements Serializable{

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
	
	public void move(int deltax, int deltay,int width,int height){
		for (Shape shape : shapes) {
			if(((shape.getX() - deltax) < 0)||(shape.getX()+ shape.getWidth()+ deltax)> width )
				shape.changeDirectionX();
			if(((shape.getY()+shape.getHeight() + deltay)> height)||(shape.getY()-deltay)< 0)
				shape.changeDirectionY();
			shape.move(deltax, deltay);
		}
	}
	
	public void saveToStream(ObjectOutputStream out) throws IOException{
		out.writeObject(shapes);
	}
	public void loadToStream(ObjectInputStream in ) throws ClassNotFoundException, IOException{
		shapes = (ArrayList<Shape>)in.readObject();
	}
	public void ReadStream(){
		
	}
	
	
}
