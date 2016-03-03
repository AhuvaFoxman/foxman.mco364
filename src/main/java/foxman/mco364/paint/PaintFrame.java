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
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PaintFrame extends JFrame {

	private JButton pencil;
	private JButton squareTool;
	private JButton ovalTool;
	private JButton lineTool;
	private JButton bucket;
	private JButton clear;
	private JButton undo;
	private JButton redo;
	private JColorChooser chooser;
	private JButton eraser;

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

		JPanel buttonPanel = new JPanel();
		JPanel colorPanel = new JPanel();

		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
		buttonPanel.setBackground(Color.WHITE);
		colorPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
		colorPanel.setBackground(Color.WHITE);

		container.add(buttonPanel, BorderLayout.NORTH);

		Dimension d = new Dimension(40, 40);

		pencil = new JButton(new ImageIcon("pencil.jpg"));
		pencil.setBackground(Color.WHITE);
		pencil.setPreferredSize(d);
		squareTool = new JButton(new ImageIcon("square.png"));
		squareTool.setBackground(Color.WHITE);
		squareTool.setPreferredSize(d);

		ovalTool = new JButton(new ImageIcon("oval.jpg"));
		ovalTool.setBackground(Color.WHITE);
		ovalTool.setPreferredSize(d);

		lineTool = new JButton(new ImageIcon("line.png"));
		lineTool.setBackground(Color.WHITE);
		lineTool.setPreferredSize(d);

		bucket = new JButton(new ImageIcon("bucket.png"));
		bucket.setBackground(Color.WHITE);
		bucket.setPreferredSize(d);

		undo = new JButton(new ImageIcon("undo.png"));
		undo.setPreferredSize(d);

		redo = new JButton(new ImageIcon("redo.jpg"));
		redo.setPreferredSize(d);

		undo.setBackground(Color.WHITE);
		redo.setBackground(Color.WHITE);
		;

		eraser = new JButton(new ImageIcon("eraser.jpg"));
		eraser.setBackground(Color.WHITE);
		eraser.setPreferredSize(d);


		chooser = new JColorChooser(Color.BLACK);
		AbstractColorChooserPanel[] panels = chooser.getChooserPanels();

		chooser.setPreviewPanel(new JPanel());
		for (AbstractColorChooserPanel accp : panels) {
			if (!accp.getDisplayName().equals("Swatches")) {
				chooser.removeChooserPanel(accp);
			}
		}

		ColorSelectionModel model = chooser.getSelectionModel();
		ChangeListener changeListener = new ChangeListener() {

			public void stateChanged(ChangeEvent changeEvent) {
				// TODO Auto-generated method stub
				color = chooser.getColor();

			}
		};

		model.addChangeListener(changeListener);

		colorPanel.add(chooser);

		colorPanel.add(undo);
		colorPanel.add(redo);
		colorPanel.add(eraser);

		color = chooser.getSelectionModel().getSelectedColor();

		this.tool = new PencilTool(color); // default

		clear = new JButton("Clear Canvas!");

		container.add(clear, BorderLayout.SOUTH);

		buttonPanel.add(colorPanel);
		buttonPanel.add(pencil);
		buttonPanel.add(squareTool);
		buttonPanel.add(ovalTool);
		buttonPanel.add(lineTool);
		buttonPanel.add(bucket);

		canvas = new Canvas();
		canvas.setBackground(Color.WHITE);

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

		lineTool.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				tool = new LineTool(color);
				canvas.setTool(tool);

			}

		});

		bucket.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				tool = new BucketTool(color);
				canvas.setTool(tool);

			}

		});

		clear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new PaintFrame().setVisible(true);
			}

		});
		undo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.undo();
			}

		});

		redo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.redo();
			}

		});

		eraser.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				tool = new Eraser();
				canvas.setTool(tool);
			}

		});
		setVisible(true);
	}

	public static void main(String[] args) {
		new PaintFrame();
	}
}
