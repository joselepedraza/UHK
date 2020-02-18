import java.util.TimerTask;

import javax.swing.JPanel;

public class MoveTask extends TimerTask {
	private ShapeList shapeList;
	private JPanel drawPanel;
	
	public MoveTask(ShapeList shapeList, JPanel drawPanel) {
		this.shapeList = shapeList;
		this.drawPanel = drawPanel;
	}
	
	@Override
	public void run() {
		shapeList.move(10, 10, drawPanel.getWidth(), drawPanel.getHeight());
		drawPanel.update(drawPanel.getGraphics());
		shapeList.draw(drawPanel.getGraphics());

	}

}
