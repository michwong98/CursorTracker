package cursortrackerapplication;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class PixelUpdate extends Component {
	
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	
	PixelUpdate(Point point) {
		super();
		x = point.x/2;
		y = point.y/2;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(x, y, 5, 5);
	}
	
}
