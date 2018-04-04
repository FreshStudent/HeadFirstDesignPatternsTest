package bookCode.ch2.part1;

public class StatisticsDisplayImpl implements IObserver,IDisplayElement{

	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum= 0.0f;
	private int numReadings;
	private WeatherDataImpl weatherData;

	public StatisticsDisplayImpl(WeatherDataImpl weatherData) { //直接传对应的实现类作为构造函数的参数，便于调用该实现类的方法,但是这样写不是很灵活，建议写接口比较好一点（向上转型）
		this.weatherData = weatherData;
		weatherData.registerObservers(this);
	}
	
	@Override
	public void update(float temp, float humidity, float pressure) {
		tempSum += temp;
		numReadings++;

		if (temp > maxTemp) {
			maxTemp = temp;
		}
 
		if (temp < minTemp) {
			minTemp = temp;
		}

		display();
	}

	@Override
	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
			+ "/" + maxTemp + "/" + minTemp);
	}
	
	
}
