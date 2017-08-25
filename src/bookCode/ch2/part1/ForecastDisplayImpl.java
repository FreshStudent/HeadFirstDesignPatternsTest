package bookCode.ch2.part1;

public class ForecastDisplayImpl implements IObserver,IDisplayElement{
	
	private float currentPressure = 29.92f;  
	private float lastPressure;
	private WeatherDataImpl weatherData;

	public ForecastDisplayImpl(WeatherDataImpl weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObservers(this);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
        lastPressure = currentPressure;
		currentPressure = pressure;
		display();
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
