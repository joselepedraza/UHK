import java.awt.Graphics2D;


public class Rectangle {
	private int height;
	private int top;
	private int left;
	private int width;
	
	public Rectangle(int height, int top, int left, int width) {
		this.height = height;
		this.top = top;
		this.left = left;
		this.width = width;
	}
	
	public void draw(Graphics2D g){
		g.drawRect(left, top, width, height);
	}

}
