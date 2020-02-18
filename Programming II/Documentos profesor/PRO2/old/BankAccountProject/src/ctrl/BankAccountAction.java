package ctrl;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

public abstract class BankAccountAction extends AbstractAction {
	
	
	public BankAccountAction(String name, String iconFileName){
		super(name, new ImageIcon(iconFileName));
		
	}

	
}
