package cursortrackerapplication;
import java.awt.Point;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class application {
	
	private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	private static int rate = 17; private static TimeUnit rateUnit = TimeUnit.MILLISECONDS;
	private static int duration = 10; private static TimeUnit durationUnit = TimeUnit.SECONDS;
	private static CursorTracker cursorTracker; private static GraphicDisplay graphics;
	
	private static Runnable recordAndGraph = new Runnable() {
		public void run() {
			Point point = cursorTracker.getMousePosition();
			if (point != null) {
				graphics.updatePixel(point);
				System.out.println(point);
			}
		}
	};
	
	public static void main(String[] args) {
		cursorTracker = new CursorTracker();
		graphics = new GraphicDisplay(cursorTracker);
		graphics.generateWindow();
		
		
		ScheduledFuture<?> scheduled = scheduler.scheduleAtFixedRate(recordAndGraph, rate, rate, rateUnit);
		scheduler.schedule(new Runnable() {
			public void run() {
				scheduled.cancel(true);
			}
		}, duration, durationUnit);
		
	}
	
	
}
