import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Shape implements Serializable {
	private int x;
	private int y;
	
	private int width;	//anchura
	private int height;	//altura
	
	private Color borderColor; 
	
	private int directionX = 1;
	private int directionY = 1;
	
	public Shape(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Shape() {}	//constructor por defecto 
	
	public abstract int calculateArea();
	protected abstract void doDraw(Graphics g);
	public void draw(Graphics g) {
		g.setColor(borderColor);	//establecemos el color
		doDraw(g);	//y pintamos
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
	//Color
	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
	
	//Move
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
