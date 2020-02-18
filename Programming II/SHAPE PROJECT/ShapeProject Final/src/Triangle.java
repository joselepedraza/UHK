import java.awt.Graphics;

public class Triangle extends Shape {


	public Triangle() {
	}
	
	public Triangle(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public int calculateArea() {
		return (getWidth()*getHeight())/2;
	}

	@Override
	protected void doDraw(Graphics g) {
		int[] xPoints = {getX(), getX() + (getWidth()/2), getX() + getWidth()};  
		int[] yPoints = {getY() + getHeight(), getY(), getY() + getHeight() };
		
		
		g.setColor(getBorderColor());
		g.drawPolygon(xPoints, yPoints, xPoints.length); //osea 3 puntos, no 4 (cierra solo)
		
	}

	
	

}
