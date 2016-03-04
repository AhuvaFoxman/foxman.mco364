package foxman.mco364.paint;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToolButton extends JButton{
	
	private Tool tool;
	private String iconName;
	
	public ToolButton(Tool tool, String iconName){
		this.tool = tool;
		this.iconName = iconName;
		this.setIcon(new ImageIcon(getClass().getResource(iconName)));
		this.setPreferredSize(new Dimension(40, 40));
		this.setBackground(Color.WHITE);
		
	}

	public Tool getTool() {
		return tool;
	}

	
}
