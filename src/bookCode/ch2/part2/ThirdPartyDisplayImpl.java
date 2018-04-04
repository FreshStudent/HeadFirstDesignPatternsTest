package bookCode.ch2.part2;
import java.util.Observer;
import java.util.Observable;
public class ThirdPartyDisplayImpl implements Observer,IDisplayElement{

	Observable observable;
	private float temp;
	private float humidity;
	private float pressure;
	
	public ThirdPartyDisplayImpl(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("自己实现的第三方的展示板是："+temp+"度"+humidity+"湿度！！！！！");
	}

	@Override
	public void update(Observable obs, Object arg) {
		if(obs instanceof WeatherDate) {
			WeatherDate weatherDate = (WeatherDate)obs;
			this.temp = weatherDate.getTemperature();;
			this.humidity = weatherDate.getHumidity();
			this.pressure = weatherDate.getPressure();
			display();
		}
	}
	
}
