package bookCode.ch2.part2;

import java.util.Observer;
import java.util.Observable;

public class StatisticsDisplayImpl implements Observer,IDisplayElement{

	Observable observable;
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum= 0.0f;
	private int numReadings;

	public StatisticsDisplayImpl(Observable observable) { 
		this.observable = observable;
		observable.addObserver(this);
	}
	
	@Override
	public void update(Observable obs, Object arg) {
		if(obs instanceof WeatherDate) {
			WeatherDate weatherDate = (WeatherDate)obs;
			this.tempSum += weatherDate.getTemperature();
			numReadings++;
			
			if (tempSum > maxTemp) {
				maxTemp = tempSum;
			}
	 
			if (tempSum < minTemp) {
				minTemp = tempSum;
			}
			display();
		}
	}

	@Override
	public void display() {
		System.out.println("Avg/Max/Min temperature = "+ (tempSum / numReadings)
			+ "/" + maxTemp + "/" + minTemp);
	}
	
}
