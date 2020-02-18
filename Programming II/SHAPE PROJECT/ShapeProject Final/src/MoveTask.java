import javax.swing.JPanel;
import java.util.TimerTask;

public class MoveTask extends TimerTask {
	private ShapeList shapeList;
	private JPanel drawPanel;
	
	public MoveTask(ShapeList shapes, JPanel panel){
		this.shapeList = shapes;
		this.drawPanel = panel;
	}
	@Override
	public void run() {
		shapeList.move(10, 10,drawPanel.getWidth(),drawPanel.getHeight());
		drawPanel.update(drawPanel.getGraphics());
		shapeList.draw(drawPanel.getGraphics());

	}
	
}
