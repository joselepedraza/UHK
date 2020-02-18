import java.awt.Graphics;

public class Elipse extends Shape {

	@Override
	public int calculateArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void doDraw(Graphics g) {
		g.setColor(getBorderColor());
		
		g.drawOval(getX(), getY(), getWidth(), getHeight());
	}

}
