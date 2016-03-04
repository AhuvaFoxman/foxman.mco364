package foxman.mco364.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Eraser extends Tool{
	
	private int x;
	private int y;

	public Eraser(PaintProperties properties) {
		super(properties);
	}

	public void mousePressed(Graphics g, int x, int y) {
		this.x = x;
		this.y = y;
		g.setColor(Color.WHITE);
		g.fillOval(x, y, 1, 1);

	}

	public void mouseReleased(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics g, int x, int y) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(8));
		g2.setColor(Color.WHITE);
		g2.drawLine(this.x, this.y, x, y);

		this.x = x;
		this.y = y;
	}

	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub

	}


}
