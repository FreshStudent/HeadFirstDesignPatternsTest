package bookCode.ch2.part2;

import java.util.Observer;
import java.util.Observable;

//CurrentConditionsDisplayImpl：目前状况报告版
public class CurrentConditionsDisplayImpl implements Observer,IDisplayElement{
	Observable observable;
	private float temperature;
	private float humidity;
	
	public CurrentConditionsDisplayImpl(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}
	
	@Override
	public void update(Observable obs, Object arg) {
		if(obs instanceof WeatherDate) {
			WeatherDate weatherDate = (WeatherDate)obs;
			this.temperature = weatherDate.getTemperature();
			this.humidity = weatherDate.getHumidity();
			display();
		}
	}
	
	@Override
	public void display() {
		System.out.println("CurrentConditionsDisplayImpl : " +temperature+" F degrees and "+humidity +" %humidity");
	}
}
