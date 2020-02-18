import java.util.ArrayList;

public class RectangleList {
	
	private ArrayList<RectangleOLD> rectangles = new ArrayList<RectangleOLD>() ;
	
	
	public int getSize() {
		return rectangles.size() ;
	}
	
	public void add(RectangleOLD r) {
		rectangles.add(r) ;
	}
	
	public int calculateArea() {
		
		int sum = 0 ;
		for(RectangleOLD r:rectangles) {
			sum += r.calculateArea() ;
		}
		return sum ;			
	}
	
	
}
