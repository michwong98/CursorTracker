package awtcursorexperiment;
import java.util.concurrent.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Runnable;

public class CursorExperimentApp extends Frame implements ActionListener {
	
	private int rate;
	private TimeUnit rateUnit;
	private int duration;
	private TimeUnit durationUnit;
	private TextField tfRate;
	private TextField tfDuration;
	
	public CursorExperimentApp() {
		
		rate = 100; rateUnit = TimeUnit.MILLISECONDS;
		duration = 10; durationUnit = TimeUnit.SECONDS;
		
		setLayout(new GridLayout(3, 1));
		setTitle("Cursor Tracker");
		setSize(250,200);
		
		Panel pnlRate = new Panel(); add(pnlRate);
		Label lblRate = new Label("Enter Rate: ");
		tfRate = new TextField(10);
		pnlRate.add(lblRate);
		pnlRate.add(tfRate);
		
		Panel pnlDuration = new Panel(); add(pnlDuration);
		Label lblDuration = new Label("Enter Duration: ");
		tfDuration = new TextField(10);
		pnlDuration.add(lblDuration);
		pnlDuration.add(tfDuration);
		
		Button btnStart = new Button("Start");
		add(btnStart);
		btnStart.addActionListener(this);
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		tfRate.setEditable(false);
		tfDuration.setEditable(false);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Tracker trackerObj = new Tracker();
		new CursorExperimentApp();
		
		/*
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
		*/
		/*
		//Records mouse position every [rate] [rateUnit].
		int rate = 100;
		TimeUnit rateUnit = TimeUnit.MILLISECONDS;
		//Records for [duration] [durationUnit].
		int duration = 10;
		TimeUnit durationUnit = TimeUnit.SECONDS;
		*/
		
		/*
		ScheduledFuture<?> scheduled = scheduler.scheduleAtFixedRate(recordMousePositions, rate, rate, rateUnit);
		//Ends scheduled after [duration] [durationUnit].
		scheduler.schedule(new Runnable() {
			public void run() {
				scheduled.cancel(true);
				System.exit(0);
			}
		}, duration, durationUnit);
		*/
		
	}
}
