package awtcursorexperiment;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.LinkedList;
public class TrackCursor {
	
	//Default constructor.
	public TrackCursor() {
	}
	
	public Point getMousePosition() {
		return MouseInfo.getPointerInfo().getLocation();
	}
	
	public Point recordPosition() {
		Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
		return mouseLocation;
	}
	
}
