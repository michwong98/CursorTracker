package cursortrackerapplication;

import java.awt.Point;

import javax.swing.SwingUtilities;

public class GraphicDisplay {
	
	private CursorTracker cursorTracker;
	private javax.swing.JFrame frame;
	
	public GraphicDisplay(CursorTracker cursorTracker) {
		this.cursorTracker = cursorTracker;
		
	}
	
	public void generateWindow() {
		int frameWidth = cursorTracker.resolution[0]/2;
		int frameHeight = cursorTracker.resolution[1]/2;
		frame = new javax.swing.JFrame();
		frame.setSize(frameWidth, frameHeight);
		frame.setVisible(true);
	}
	
	public void updatePixel(Point point) {
		frame.getContentPane().add(new PixelUpdate(point));
		SwingUtilities.updateComponentTreeUI(frame);
	}
	
}
