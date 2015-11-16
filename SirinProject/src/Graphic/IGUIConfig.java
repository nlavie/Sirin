package Graphic;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;

public interface IGUIConfig {
	static final int MAX_SCORE = 100;
	static final int PREF_W = 800;
	static final int PREF_H = 650;
	static final int BORDER_GAP = 30;
	static final Color GRAPH_POINT_COLOR = new Color(150, 50, 50, 180);
	static final Stroke GRAPH_STROKE = new BasicStroke(3f);
	static final int GRAPH_POINT_WIDTH = 12;
	static final int Y_HATCH_CNT = 10;
	static final int VERTICAL_SPACING_RESOURCES_TOPICS = 30;
	static final int HORIZONTAL_SPACING_RESOURCES_TOPICS = 2 * BORDER_GAP;
	static final int AMOUNT_SAMPLES = 20;
	static final int AMOUNT_COLORS = 3; // amount colors equals to amount resources
	static Font TOPIC_FONT = new Font("TimesRoman", Font.PLAIN, 16);
	static final int LAST_SAMPLES_SPACING = 100;
	static final int MIDDLE_TOPIC_SPACING=200;
	static Font CENTER_TOPIC_FONT=new Font("TimesRoman", Font.PLAIN, 24);
	static Color TOPIC_COLOR=Color.black;
	static Color CENTER_TOPIC_COLOR = Color.orange;
	static Color FIRST_RESOURCE_COLOR = Color.green;
	static Color SECOND_RESOURCE_COLOR=Color.blue;
	static Color THIRD_RESOURCE_COLOR = Color.red;
}
