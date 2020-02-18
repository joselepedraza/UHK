
public class Triangle extends Shape {

	public Triangle(int width, int height) {
		super(width, height);
	}

	@Override
	public int calculateArea() {
		return (getWidth()*getHeight())/2;
	}

}
