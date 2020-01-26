package awtcursorexperiment;
import java.util.concurrent.*;
import java.awt.Point;
import java.lang.Runnable;

public class CursorExperimentApp {
	
	public static void main(String[] args) throws InterruptedException {
		
		Tracker trackerObj = new Tracker();
		
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		//Callback for recording mouse position.
		Runnable recordMousePositions = new Runnable() {
			public void run() {
				Point mouseLocation = trackerObj.getMousePosition();
				int x = mouseLocation.x;
				int y = mouseLocation.y;
				System.out.format("[%d, %d]\n", x, y);
			}
		};
		
		//Records mouse position every [rate] [rateUnit].
		int rate = 100;
		TimeUnit rateUnit = TimeUnit.MILLISECONDS;
		//Records for [duration] [durationUnit].
		int duration = 10;
		TimeUnit durationUnit = TimeUnit.SECONDS;
		
		ScheduledFuture<?> scheduled = scheduler.scheduleAtFixedRate(recordMousePositions, rate, rate, rateUnit);
		//Ends scheduled after [duration] [durationUnit].
		scheduler.schedule(new Runnable() {
			public void run() {
				scheduled.cancel(true);
				System.exit(0);
			}
		}, duration, durationUnit);
		
	}
}
