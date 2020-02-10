package cursortrackerapplication;
import java.awt.*;
import java.util.*;

public class CursorTracker {
	
	//List of mouse positions.
	public LinkedList<Point> pointsRecord;
	
	//Screen resolution of main display.
	public int[] resolution;
	
	//Default constructor.
	public CursorTracker() {
		
		//List of mouse positions.
		pointsRecord = new LinkedList<Point>();
		
		resolution = new int[2];
		Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
		resolution[0] = screenResolution.width; resolution[1] = screenResolution.height;
		
	}
	
	//Returns the mouse's current position.
	public Point getMousePosition() {
		Point point = MouseInfo.getPointerInfo().getLocation();
		
		//Limited to main display.
		if (point.x >= 0 && point.x <= resolution[0] && point.y >= 0 && point.y <= resolution[1]) {
			pointsRecord.add(point);
			return point;
		} else { //Not main display.
			return null;
		}
	}
	
	
	
}
