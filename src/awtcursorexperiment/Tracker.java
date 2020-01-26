package awtcursorexperiment;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.util.LinkedList;
import java.util.ListIterator;

public class Tracker {
	
	private TrackCursor trackCursor;
	private LinkedList<Point> recordedPoints = null;
	private int screenHeight, screenWidth;
	
	//Default constructor.
	public Tracker() {
		
		//Used to get and save mouse position.
		trackCursor = new TrackCursor();
		recordedPoints = new LinkedList<Point>();
		
		//Records the screen size.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenHeight = screenSize.height; screenWidth = screenSize.width;
	}
	
	public Point getMousePosition() {
		
		Point mouseLocation = trackCursor.getMousePosition();
		//Saves point to LinkedList.
		recordedPoints.add(mouseLocation);
		return mouseLocation;
		
	}
	
	public int[][] recordedPointsToArray() {
		
		int[][] recordedPointsArr = new int[recordedPoints.size()][2];
		
		ListIterator<Point> iterator = recordedPoints.listIterator();
		
		//Iterates over linked list.
		int n = 0;
		while (iterator.hasNext()) {
			Point recordedPoint = iterator.next();
			int x = recordedPoint.x;
			int y = recordedPoint.y;
			recordedPointsArr[n][0] = x;
			recordedPointsArr[n][1] = y;
			n++;
		}
		
		return recordedPointsArr;
		
	}
	
	
	
}
