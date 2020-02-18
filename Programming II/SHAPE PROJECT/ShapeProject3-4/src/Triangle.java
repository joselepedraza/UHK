import java.awt.Graphics;

public class Triangle extends Shape {


	public Triangle() {
	}
	
	public Triangle(int[] vx, int[] vy) {
		super(vx, vy);
	}

	@Override
	public int calculateArea() {
		return (getWidth()*getHeight())/2;
	}

	@Override
	public void draw(Graphics g) {
		g.drawPolygon(getVx(), getVy(), 3);
		
	}

	
	

}
