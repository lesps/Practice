package upenn.cis541.Stopwatch;

import java.util.TimerTask;

public class Tick extends TimerTask{
	public void run(){
		boolean shouldStop = Stopwatch.hours >= 99;

		Stopwatch.hundredths++;

		if(Stopwatch.hundredths >= 99){
			Stopwatch.seconds++;
			if(!shouldStop && !(Stopwatch.seconds >= 59) && !(Stopwatch.minutes >= 59)) {
				Stopwatch.hundredths = 0;
			}
		}
		if(Stopwatch.seconds >= 59){
			Stopwatch.minutes++;
			if(!shouldStop && !(Stopwatch.minutes >= 59)) {
				Stopwatch.seconds = 0;
			}
		}
		if(Stopwatch.minutes >= 59){
			Stopwatch.hours++;
			if(!shouldStop) {
				Stopwatch.minutes = 0;
			}
		}

		Stopwatch.display();
	}
}