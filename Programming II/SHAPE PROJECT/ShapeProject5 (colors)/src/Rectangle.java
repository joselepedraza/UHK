import java.awt.Graphics;

public class Rectangle extends Shape{
	
	
	public Rectangle() {}
	
	public Rectangle(int x, int y, int width, int height) {	//constructor llama a constructor de superclase
		super(x,y,width, height);
	}

	@Override
	public int calculateArea() {
		return getWidth() * getHeight();
	}
	
	//@Override	//creo que no hace falta
	protected void doDraw(Graphics g) {	//pintarse (necestiamos saber donde)
		g.setColor(getBorderColor());
		g.drawRect(getX(), getY(), getWidth(), getHeight());
	}
	
}
