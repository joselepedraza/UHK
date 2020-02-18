import java.awt.Graphics;

public class Elipse extends Shape {

	public Elipse() {}
	
	@Override
	public int calculateArea() {
		
		return 0;
	}

	@Override
	protected void doDraw(Graphics g) {
		g.setColor(getBorderColor());
		g.drawOval(getX(), getY(), getWidth(), getHeight());
	}

}
