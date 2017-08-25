package bookCode.ch2.part1;

import java.util.ArrayList;

public class WeatherDataImpl implements ISubject{
	
	private ArrayList observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	
	public WeatherDataImpl() {
		observers = new ArrayList();
	}

	@Override
	public void registerObservers(IObserver o) {
		observers.add(o);
	}

	@Override
	public void removeObservers(IObserver o) {
		if(!observers.isEmpty()) observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for(int i=0;i<observers.size();i++) {
			IObserver ob = (IObserver)observers.get(i);
			ob.update(temperature, humidity,pressure);
		}
	}

	public void measurementsChanged(){
		notifyObservers();
	}
	
	//设置改变的温度、湿度、气压值
	public void setMeasurements(float temperature,float humidity,float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
}
