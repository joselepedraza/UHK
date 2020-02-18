import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Shape implements Serializable{

	private int x;
	private int y;
	
	private int width;
	private int height;
	
	private int directionX = 1;
	private int directionY = 1;
	
	private Color borderColor;
	
	public Shape() {}
	
	public Shape(int x, int y, int width, int height) {
		this.x = x ;
		this.y = y ;
		this.width = width;
		this.height = height;
	}
	
	public abstract int calculateArea()  ;
	protected abstract void doDraw(Graphics g) ;
	
	public void draw(Graphics g) {
		g.setColor(borderColor);
		doDraw(g);
	}
	public void move(int deltax, int deltay) {
		this.x += this.directionX * deltax;
		this .y += this.directionY * deltay;
	}
	public void changeDirectionX(){
		directionX *= -1; 
	}
	public void changeDirectionY(){
		directionY *= -1;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public int getDirectionX() {
		return directionX;
	}

	public void setDirectionX(int directionX) {
		this.directionX = directionX;
	}

	public int getDirectionY() {
		return directionY;
	}

	public void setDirectionY(int directionY) {
		this.directionY = directionY;
	}
		
}
