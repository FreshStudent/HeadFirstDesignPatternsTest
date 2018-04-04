package bookCode.ch2.part1;

//CurrentConditionsDisplayImpl：目前状况报告版
public class CurrentConditionsDisplayImpl implements IObserver,IDisplayElement{

	private float temperature;
	private float humidity;
	private ISubject weatherData;
	
	//public CurrentConditionsDisplayImpl(ISubject weatherData)：这里构造函数的参数ISubject是接口，此参数可以是这个接口的实现类impl（儿子），好处是方法可以通用，不用写死到底传那个实现类进来，比较灵活，向上转型；
	public CurrentConditionsDisplayImpl(ISubject weatherData) { 
		this.weatherData = weatherData;  //构造器需要weatherData对象（也就是主题），作为注册之用。
		weatherData.registerObservers(this);//根据传入的实现类impl来确定调用其impl的方法。
	}
	
	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;   //当update被调用的时候，把温度和湿度保存起来，然后调用display
		display();
		
	}
	
	@Override
	public void display() {
		System.out.println("CurrentConditionsDisplayImp : "+temperature+" 度 and "+humidity+" 湿度");
	}
}
