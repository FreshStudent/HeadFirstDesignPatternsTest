package bookCode.ch2.part2;
import java.util.Observer;
import java.util.Observable;
//预测报告版
public class ForecastDisplayImpl implements Observer,IDisplayElement{
	
	Observable observable;
	private float currentPressure = 29.92f;  
	private float lastPressure;

	public ForecastDisplayImpl(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable obs, Object arg) {
		if(obs instanceof WeatherDate) {
			WeatherDate weatherDate = (WeatherDate)obs;
			lastPressure = currentPressure;
			currentPressure = weatherDate.getPressure();
			display();
		}
	}
	
	@Override
	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("More of the same");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
	}
	
}
