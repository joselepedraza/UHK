import java.awt.Graphics2D;
import java.util.Vector;


public class Drawing {
	private Graphics2D graphics;
	private Vector<Rectangle> rectangles = new Vector<Rectangle>();
	
	public Drawing(Graphics2D graphics) {
		this.graphics = graphics;
	}
	
	public void draw(){
		for (Rectangle r : rectangles) {
			r.draw(graphics);
		}
	}
	
	public void addRectangle(Rectangle r){
		rectangles.add(r);
	}
	

}
