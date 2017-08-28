package bookCode.ch2.part2;

public class WeatherMainRun {

	public static void main(String args[]) {
		
		WeatherDate weatherData = new WeatherDate();
		
		CurrentConditionsDisplayImpl currentConditionsDisplayImp = new CurrentConditionsDisplayImpl(weatherData);
		StatisticsDisplayImpl statisticsDisplayImpl = new StatisticsDisplayImpl(weatherData);
		ForecastDisplayImpl forecastDisplayImpl = new ForecastDisplayImpl(weatherData);
		ThirdPartyDisplayImpl thirdPartyDisplayImpl = new ThirdPartyDisplayImpl(weatherData);
		weatherData.setMeasurements(1, 78, 123);
		weatherData.setMeasurements(10, 100, 888);
		
	}
}
