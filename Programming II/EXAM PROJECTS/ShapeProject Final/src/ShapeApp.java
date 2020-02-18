
public class ShapeApp {

	public static void main(String[] args) {
		ShapeList list = new ShapeList();
		/*
		list.addShape(new Rectangle(10,15));
		list.addShape(new Triangle(20,10));
		*/
		//Shape s = new Rectangle()
		
		int area = list.calculateArea();
		
		System.out.println(area);
	}

}
