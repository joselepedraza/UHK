import javax.swing.SwingUtilities;

import fim.utils.Application;
import fim.utils.Console;


public class DrawRectApp extends Application {

	@Override
	public void start() {
		Drawing d = new Drawing(graph);
		Rectangle r = new Rectangle(10, 10, 100, 100);
		
		d.addRectangle(r);
		d.draw();
		
		
		out.switchView(Console.VIEW_GRAPH);
		out.repaint();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new DrawRectApp().start();
			}
		});
	}

}
