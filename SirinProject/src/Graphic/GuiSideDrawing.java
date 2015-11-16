package Graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;

import Resources.IResource;

public class GuiSideDrawing implements IGUIConfig {
	private static int flagFirstGuiShow1 = 1;// in order to initate GUI only once											// once
	private static int flagFirstGuiShow2 = 1;
	private static DrawGraph mainPanel = null;// /GUI singleton
	private static JFrame frame = null;// GUI singleton

	public static void printTopics(Graphics g, int width, int height) {
		Graphics2D g3 = (Graphics2D) g;
		g3.setFont(TOPIC_FONT);
		g3.setColor(TOPIC_COLOR);
		g3.drawString(String.valueOf(MAX_SCORE), BORDER_GAP, BORDER_GAP - 2);// draw
																				// max
																				// graph
																				// value
		g3.drawString("last " + AMOUNT_SAMPLES + " samples", width - BORDER_GAP
				/ 2 - LAST_SAMPLES_SPACING, height - BORDER_GAP / 2); // draw amount
														// last samples
														// - x graph
														// value
		g3.setColor(CENTER_TOPIC_COLOR);
		g3.setFont(CENTER_TOPIC_FONT);
		g3.drawString("Resources updates every few seconds", width / 2 - MIDDLE_TOPIC_SPACING,
				height / 2);
	}

	public static JFrame getFrame() {// /kind of singleton for frame
		if (flagFirstGuiShow1 == 1) {
			frame = new JFrame("DrawGraph");// defined and located only once
			frame.setLocationByPlatform(true);
			flagFirstGuiShow1 = 0;
			return frame;
		} else {
			frame.setVisible(false);// in order to create refresh must change
									// visibility
			return frame;
		}
	}

	public static DrawGraph getDrawGraph(ArrayList<IResource> manager) {// /kind
																			// of
																			// singleton
																			// for
																			// frame
		if (flagFirstGuiShow2 == 1) {
			mainPanel = mainPanel = new DrawGraph(manager);// defined only once
			flagFirstGuiShow2 = 0;
			return mainPanel;
		} else {
			return mainPanel;
		}
	}
}
