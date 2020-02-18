
public class ShapeApp {

	public static void main(String[] args) {
		ShapeList shapes = new ShapeList() ;
		
		Shape s = new NewRectangle(10,15, 1, 1) ;
		shapes.addShape(s);
		s = new Triangle(20,10, 2, 3);
		shapes.addShape(s);
		
		int area = shapes.calculateArea() ;
		
		System.out.println(area);
	}

}
