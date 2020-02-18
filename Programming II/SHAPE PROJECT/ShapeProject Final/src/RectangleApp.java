
public class RectangleApp {

	public static void main(String[] args) {
		/*Rectangle r = new Rectangle(5,10);
		System.out.println(r.calculateArea());*/
		//System.out.println( (new Rectangle(5,10)).calculateArea()); se puede usar directamente
		
		RectangleList list = new RectangleList();
		list.add(new RectangleOld(10,20));
		list.add(new RectangleOld(15,30));
		list.add(new RectangleOld(5,8));
		
		int area = list.calculateAreas();
		System.out.println(area);
		
	}

}
