import java.awt.Graphics;

public abstract class Shape {
	private int x;
	private int y;
	
	private int width;	//anchura
	private int height;	//altura
	
	private int vx[];	//para los 3 puntos del triangulo
	private int vy[];
	
	public Shape(int x, int y, int width, int height) {
		//super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Shape(int[] vx, int[] vy) {
		//super();
		this.setVx(vx);
		this.setVy(vy);
	}
	
	public Shape() {}	//constructor por defecto 
	
	public abstract int calculateArea();
	public abstract void draw(Graphics g);
	
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

	public int[] getVx() {
		return vx;
	}

	public void setVx(int vx[]) {
		this.vx = vx;
	}

	public int[] getVy() {
		return vy;
	}

	public void setVy(int vy[]) {
		this.vy = vy;
	}
	
	

}
