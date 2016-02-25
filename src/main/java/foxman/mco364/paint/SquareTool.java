package foxman.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

public class SquareTool implements Tool{

	private int x1, y1;
	private int x2, y2;
	private int width, height;
	
	private Color color;
	
	public SquareTool(Color c){
		
		this.color = c;
	}
	

	public void mousePressed(Graphics g, int x, int y) {
		x1 = x;
		y1 = y;
		x2 = x;
		y2 = y;
		width = 0;
		height = 0;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		x2 = x;
		y2 = y;
		width = Math.abs(x2 - x1);
		height = Math.abs(y2 - y1);
		g.setColor(color);
		g.drawRect(x1, y1, width, height);
	
	}

	public void mouseDragged(Graphics g, int x, int y) {
		x2 = x;
		y2 = y;
		width = Math.abs(x2 - x1);
		height = Math.abs(y2 - y1);
	}

	public void drawPreview(Graphics g) {
		g.setColor(color);
		g.drawRect(x1, y1, width, height);
	}


	public void mouseClicked(Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	
	

}
