package bookCode.ch2.part1;

public class WeatherMainRun {

	public static void main(String args[]) {
		WeatherDataImpl weatherDataImpl = new WeatherDataImpl();
		
		CurrentConditionsDisplayImpl currentConditionsDisplayImp = new CurrentConditionsDisplayImpl(weatherDataImpl);
		StatisticsDisplayImpl statisticsDisplayImp = new StatisticsDisplayImpl(weatherDataImpl);
		ForecastDisplayImpl forecastDisplayImp = new ForecastDisplayImpl(weatherDataImpl);
		
		//自己实现的第三方报告版
		ThirdPartyDisplayImpl thirdPartyDisplayImpl = new ThirdPartyDisplayImpl(weatherDataImpl);
		
		weatherDataImpl.setMeasurements(1, 78, 123);
		weatherDataImpl.setMeasurements(9, 90, 666);
		weatherDataImpl.setMeasurements(10, 100, 888);
		
	}
}
