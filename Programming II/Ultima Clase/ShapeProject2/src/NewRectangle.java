import java.awt.Graphics;

public class NewRectangle extends Shape{
	
	public NewRectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public NewRectangle() {} 

	@Override
	public int calculateArea() {
		return getWidth() * getHeight() ;
	}
	
	protected void doDraw(Graphics g) {
		g.setColor(getBorderColor());
		g.drawRect(getX(), getY(), getWidth(), getHeight());
	}	

}
