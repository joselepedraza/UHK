import java.util.ArrayList;


public class RectangleList {
	//recordar que debemos poner el tipo de objeto en el template para las colecciones
	private ArrayList<RectangleOld> rectangles = new ArrayList<RectangleOld>();
	
	public int getSize() {
		return rectangles.size();
	}
	
	public void add(RectangleOld r) {
		rectangles.add(r);
	}
	
	public int calculateAreas() {
		int areasum = 0;
		for(RectangleOld r : rectangles) {
			areasum += r.calculateArea(); //r.getHeight() * r.getWidth();
		}
		return areasum;
	}
	
}
