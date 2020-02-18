
public class Rectangle extends Shape{
	
	public Rectangle(int width, int height) {	//constructor llama a constructor de superclase
		super(width, height);
	}

	@Override
	public int calculateArea() {
		return getWidth() * getHeight();
	}
	
	public void doAny() {
		
	}
	
}
