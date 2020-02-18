
public class RectangleOLD {
	private int width;
	private int height;
	
	public RectangleOLD(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int calculateArea() {
		return width*height  ;
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
