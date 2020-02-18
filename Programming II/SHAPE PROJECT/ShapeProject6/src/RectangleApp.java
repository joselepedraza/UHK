
public class RectangleApp {

	public static void main(String[] args) {
		RectangleList rectangles = new RectangleList() ;
		
		rectangles.add(new RectangleOLD(10,20));
		rectangles.add(new RectangleOLD(15,30));
		rectangles.add(new RectangleOLD(5,8));
		
		int area = rectangles.calculateArea() ;
		
		System.out.println(area);
		
	}

}
