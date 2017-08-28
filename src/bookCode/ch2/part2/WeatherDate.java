package bookCode.ch2.part2;

import java.util.Observable;
import java.util.Observer;

public class WeatherDate extends Observable{
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherDate() {}  
	
	public void measurementsChange() {
		setChanged();
		notifyObservers();  //采取“拉”的方式来建立数据结构
	}

	public void setMeasurements(float temperature,float humidity,float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChange();
	}

	public float getTemperature() {
		return temperature;
	}
	public float getHumidity() {
		return humidity;
	}
	public float getPressure() {
		return pressure;
	}
	
}
