package Graphic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import javax.print.attribute.standard.DateTimeAtCreation;
import javax.swing.*;

import Resources.IResource;

@SuppressWarnings("serial")
public class DrawGraph extends JPanel implements IGUIConfig {
	private ArrayList<Color> colors;//will hold list of colors in the amount of resources needed
	private ArrayList<IResource> resources;//will hold all resources

	public DrawGraph(ArrayList<IResource> ResourceList) {//Constructor - init colors and resources
		colors = new ArrayList<Color>();
		resources = new ArrayList<IResource>();
		colors.add(FIRST_RESOURCE_COLOR); // ///fill with amount colors you want -
									// according to number of resources
		colors.add(SECOND_RESOURCE_COLOR);
		colors.add(THIRD_RESOURCE_COLOR);
		this.resources = ResourceList;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int index = 0;// /for color//
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		List<List<Integer>> severalScores = new ArrayList<List<Integer>>();//several scores will hold all resources last Stats
		for (IResource res : resources) {
			List<Integer> scores = new ArrayList<Integer>();//scores will hold last stats for specific resource
			scores.addAll(0, res.getLastStat(AMOUNT_SAMPLES));
			severalScores.add(scores);
		}
		GuiSideDrawing.printTopics(g, getWidth(), getHeight());// /printing all
																// topics - USING GuiSideDrawing class

		// /this part handles each resource separately and creates graph data
		// for it///
		for (List<Integer> scores : severalScores) {// for each resource data
													// list in each resource
			double xScale = ((double) getWidth() - 2 * BORDER_GAP)
					/ (scores.size() - 1);// creates x and y scaling according
											// to data range
			double yScale = ((double) getHeight() - 2 * (BORDER_GAP + 5))
					/ (MAX_SCORE - 1);

			List<Point> graphPoints = new ArrayList<Point>();// list of points
																// creates a
																// graph
			for (int i = 0; i < scores.size(); i++) {
				int x1 = (int) (i * xScale + BORDER_GAP);// transform each point
															// from its value to
															// its matching
															// value according
															// to scalling
				int y1 = (int) ((MAX_SCORE - scores.get(i)) * yScale + BORDER_GAP);
				graphPoints.add(new Point(x1, y1));
			}

			// create x and y axes
			g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP,
					BORDER_GAP);
			g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth()
					- BORDER_GAP, getHeight() - BORDER_GAP);

			// create hatch marks for y axis.
			for (int i = 0; i < Y_HATCH_CNT; i++) {
				int x0 = BORDER_GAP;
				int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
				int y0 = getHeight()
						- (((i + 1) * (getHeight() - BORDER_GAP * 2))
								/ Y_HATCH_CNT + BORDER_GAP);
				int y1 = y0;
				g2.drawLine(x0, y0, x1, y1);
			}

			// and for x axis
			for (int i = 0; i < scores.size() - 1; i++) {
				int x0 = (i + 1) * (getWidth() - BORDER_GAP * 2)
						/ (scores.size() - 1) + BORDER_GAP;
				int x1 = x0;
				int y0 = getHeight() - BORDER_GAP;
				int y1 = y0 - GRAPH_POINT_WIDTH;
				g2.drawLine(x0, y0, x1, y1);
			}

			// /draw lines in graph with matching color for each graph
			Stroke oldStroke = g2.getStroke();
			g2.setColor(colors.get(index));// //choose different color for each
											// grape
			g2.drawString(resources.get(index).getResourceName(),
					(HORIZONTAL_SPACING_RESOURCES_TOPICS) * (index + 1),
					VERTICAL_SPACING_RESOURCES_TOPICS * (index + 1));// print
																		// resource
																		// topic
																		// with
																		// its
																		// matching
																		// name
																		// and
																		// color
			g2.setStroke(GRAPH_STROKE);
			for (int i = 0; i < graphPoints.size() - 1; i++) {
				int x1 = graphPoints.get(i).x;
				int y1 = graphPoints.get(i).y;
				int x2 = graphPoints.get(i + 1).x;
				int y2 = graphPoints.get(i + 1).y;
				g2.drawLine(x1, y1, x2, y2);
			}

			// fill the dots
			g2.setStroke(oldStroke);
			g2.setColor(GRAPH_POINT_COLOR);
			for (int i = 0; i < graphPoints.size(); i++) {
				int x = graphPoints.get(i).x - GRAPH_POINT_WIDTH / 2;
				int y = graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2;
				;
				int ovalW = GRAPH_POINT_WIDTH;
				int ovalH = GRAPH_POINT_WIDTH;
				g2.fillOval(x, y, ovalW, ovalH);
			}
			if (index == AMOUNT_COLORS - 1) {
				index = 0;
			} else {
				index++;
			}
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}

	public static void createAndShowGui(ArrayList<IResource> ResourceList) {// create
																		// //
																		// graph
		DrawGraph mainPanel = GuiSideDrawing.getDrawGraph(ResourceList); // get gui -
																	// singleton
		JFrame frame = GuiSideDrawing.getFrame();// get gui - singleton
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setVisible(true);
	}

}