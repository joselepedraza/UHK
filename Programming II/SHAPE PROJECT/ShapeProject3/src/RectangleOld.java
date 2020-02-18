
public class RectangleOld {
	
	private int width;	//anchura
	private int height;	//altura
	
	public RectangleOld(int width, int height) {
		
		this.width = width;
		this.height = height;
	}
	
	public int calculateArea() {
		return width * height;
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

	
	
}
