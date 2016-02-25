package foxman.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool implements Tool {

	private Color c;

	public BucketTool(Color c) {
		this.c = c;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(Graphics g, int x, int y, BufferedImage image) {
		// TODO Auto-generated method stub

		fill(x, y, image.getRGB(x, y), c.getRGB(), image);

	}

	private void fill(int x, int y, int oldCol, int newCol, BufferedImage image) {
		Queue<Point> queue = new LinkedList<Point>();

		queue.add(new Point(x, y));

		Point p;
		while (!queue.isEmpty()) {

			p = queue.remove();

			int x2 = p.getX();
			int y2 = p.getY();

			if (x2 > 0 && y2 > 0 && x2 < image.getWidth()
					&& y2 < image.getHeight() && image.getRGB(x2, y2) == oldCol) {

				image.setRGB(x2, y2, newCol);

				queue.add(new Point(x2 - 1, y2));
				queue.add(new Point(x2 + 1, y2));
				queue.add(new Point(x2, y2 - 1));
				queue.add(new Point(x2, y2 + 1));
			}
		}

	}

}
