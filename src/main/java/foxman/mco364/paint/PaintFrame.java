package foxman.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {

	private JButton pencil;
	private JButton squareTool;
	private JButton ovalTool;
	private JButton bucket;
	private JButton red;
	private JButton orange;
	private JButton yellow;
	private JButton green;
	private JButton blue;
	private JButton purple;
	private JButton pink;
	private JButton black;
	private JButton clear;

	private Tool tool;
	private Canvas canvas;
	private Color color;

	public PaintFrame() {
		setTitle("PaintFrame");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.setBackground(Color.WHITE);

		JPanel buttonPanel = new JPanel();
		JPanel colorPanel = new JPanel();

		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 3));
		colorPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));

		container.add(buttonPanel, BorderLayout.NORTH);

		pencil = new JButton(new ImageIcon("pencil.jpg"));
		pencil.setBackground(Color.WHITE);
		squareTool = new JButton(new ImageIcon("square.png"));
		squareTool.setBackground(Color.WHITE);
		ovalTool = new JButton(new ImageIcon("oval.jpg"));
		ovalTool.setBackground(Color.WHITE);
		bucket = new JButton(new ImageIcon("bucket.png"));
		bucket.setBackground(Color.WHITE);
		color = Color.BLACK; //default
		this.tool = new PencilTool(color); // default
		
		Dimension d = new Dimension(30,30);
		red = new JButton();
		red.setBackground(Color.RED);
		red.setPreferredSize(d);
		orange = new JButton();
		orange.setBackground(Color.ORANGE);
		orange.setPreferredSize(d);
		yellow = new JButton();
		yellow.setBackground(Color.YELLOW);
		yellow.setPreferredSize(d);
		green = new JButton();
		green.setBackground(Color.GREEN);
		green.setPreferredSize(d);
		blue = new JButton();
		blue.setBackground(Color.BLUE);
		blue.setPreferredSize(d);
		purple = new JButton();
		purple.setBackground(Color.MAGENTA);
		purple.setPreferredSize(d);
		pink = new JButton();
		pink.setBackground(Color.PINK);
		pink.setPreferredSize(d);
		black = new JButton();
		black.setBackground(Color.BLACK);
		black.setPreferredSize(d);
		clear = new JButton("Clear Canvas!");
		
		container.add(clear, BorderLayout.SOUTH);

		colorPanel.add(red);
		colorPanel.add(orange);
		colorPanel.add(yellow);
		colorPanel.add(green);
		colorPanel.add(blue);
		colorPanel.add(purple);
		colorPanel.add(pink);
		colorPanel.add(black);

		buttonPanel.add(colorPanel);
		buttonPanel.add(pencil);
		buttonPanel.add(squareTool);
		buttonPanel.add(ovalTool);
		buttonPanel.add(bucket);

		canvas = new Canvas();

		add(canvas, BorderLayout.CENTER);

		pencil.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				tool = new PencilTool(color);
				canvas.setTool(tool);
			}

		});

		squareTool.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				tool = new SquareTool(color);
				canvas.setTool(tool);

			}

		});
		ovalTool.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				tool = new OvalTool(color);
				canvas.setTool(tool);

			}

		});
		bucket.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				 tool = new BucketTool();
				canvas.setTool(tool);

			}

		});
		
		red.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				color = Color.RED;
				canvas.setColor(color);

			}

		});
		
		orange.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				color = Color.ORANGE;
				canvas.setColor(color);

			}

		});
		
		yellow.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				color = Color.YELLOW;
				canvas.setColor(color);

			}

		});
		
		green.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				color = Color.GREEN;
				canvas.setColor(color);

			}

		});
		
		blue.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				color = Color.BLUE;
				canvas.setColor(color);

			}

		});
		
		purple.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				color = Color.MAGENTA;
				canvas.setColor(color);

			}

		});
		
		pink.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				color = Color.PINK;
				canvas.setColor(color);

			}

		});
		
		black.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				color = Color.BLACK;
				canvas.setColor(color);

			}

		});
		
		clear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new PaintFrame().setVisible(true);

			}

		});
		
		

		setVisible(true);
	}

	public static void main(String[] args) {
		new PaintFrame();
	}
}
