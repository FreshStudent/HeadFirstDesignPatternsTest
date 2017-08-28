## Chapter 02 the observer pattern 第02章 观察者模式
 
**ch2.part1**
 
### 1. The Observer Pattern defines a one-to-many dependency between objects so that one object change state,all of its dependents are notified and updated automatically.   (P51)
观察者模式：定义了对象之间的一对多依赖，这样一来，当一个对象改变状态时，它的所有依赖者都会收到通知并自动更新。

>
> 简单来说，有点类似微博的过程，关注某个大V后，大V更新的状态会推送到我们的微博首页，简单理解。
> 

### 2. Design Principle Strive for loosely coupled designs between objects that interact. (P53)

设计原则：为了交互对象之间的松耦合设计而努力。

### 3. Loosely coupled designs allow use to build flexible OO systems that can handle change because they minimize the interdependency between objects. (P53)

松耦合的设计之所以能让我们建立有弹性的OO系统，能够应对变化，是因为对象之间的互相依赖降到了最低。


---

### 今天要做一个天气预报的系统，不同的展示板都需要及时获取气象中心发布的天气信息。

### 相关类UML图：
![类UML图](https://github.com/FreshStudent/HeadFirstDesignPatternsTest/blob/master/src/bookCode/ch2/part1/ch2_part1UML.png)

### Code：
#### interface: ISubject.java、IObserver.java、IDisplayElement.java

``` java
ISubject.java  被观察的subject
public interface ISubject {
	public void registerObservers(IObserver o);//注册观察者，等于是关注。
	public void removeObservers(IObserver o);//移除观察者，等于是取消关注。
	public void notifyObservers(); //通知观察者们ßß 

}

IObserver.java
public interface IObserver {
	public void update(float temp,float humidity,float pressure);
}

IDisplayElement.java
public interface IDisplayElement {
	public void display();
}

```
---

####  WeatherDataImpl implements ISubject
``` java
public class WeatherDataImpl implements ISubject{
	//利用arrayList来记录观察者
	private ArrayList observerList;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherDataImpl() {
		observerList = new ArrayList();
	}

	//注册观察者时候，只需要在list中add即可
	@Override
	public void registerObservers(IObserver o) {
		observerList.add(o);
	}

	//取消观察者时候，只需要在list中remove即可
	@Override
	public void removeObservers(IObserver o) {
		if(!observerList.isEmpty()) observerList.remove(o);
	}

	/**
	 * 这个比较有趣。
	 * 通过遍历observerList，把当前气象台状态告诉每一个观察者。
	 * 因为观察者们各自都实现了update，所以气象台知道如何通知他们。
	 */
	@Override
	public void notifyObservers() {
		for(int i=0;i<observerList.size();i++) {
			IObserver ob = (IObserver)observerList.get(i);
			ob.update(temperature, humidity,pressure);
		}
	}

	//当气象站得到最新的消息时候，通知观察者
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
```

``` java
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

//StatisticsDisplayImpl:统计报告版
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

//预测报告版
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


```
---

``` java
运行类：WeatherMainRun.java
public class WeatherMainRun {

	public static void main(String args[]) {
		WeatherDataImpl weatherDataImpl = new WeatherDataImpl();
		
		CurrentConditionsDisplayImpl currentConditionsDisplayImp = new CurrentConditionsDisplayImpl(weatherDataImpl);
		StatisticsDisplayImpl statisticsDisplayImp = new StatisticsDisplayImpl(weatherDataImpl);
		ForecastDisplayImpl forecastDisplayImp = new ForecastDisplayImpl(weatherDataImpl);
		
		weatherDataImpl.setMeasurements(1, 78, 123);
		weatherDataImpl.setMeasurements(9, 90, 666);
		weatherDataImpl.setMeasurements(10, 100, 888);
		
	}
}

运行结果：
CurrentConditionsDisplayImp : 1.0 度 and 78.0 湿度
Avg/Max/Min temperature = 1.0/1.0/1.0
Forecast: Improving weather on the way!
CurrentConditionsDisplayImp : 9.0 度 and 90.0 湿度
Avg/Max/Min temperature = 5.0/9.0/1.0
Forecast: Improving weather on the way!
CurrentConditionsDisplayImp : 10.0 度 and 100.0 湿度
Avg/Max/Min temperature = 6.6666665/10.0/1.0
Forecast: Improving weather on the way!

```

> 程序解读：
> 
> 气象站是一个发布天气信息的主体 **（subject）**  <br>
> 每个报告版都是一名观察者 **（observer）** ，并且需要报告版展示 **（display）** 来自气象台的信息。<br> 
> 所以可以定义3个接口，分别是subject、observer、display。<br>
> subject: <br>
>    registerObservers(注册观察者，等于是关注)<br>
>    removeObservers(移除观察者，等于是取消关注)<br>
>    notifyObservers(通知观察者们) <br>
> 

### 详情请看以下类图：
![类UML图](https://github.com/FreshStudent/HeadFirstDesignPatternsTest/blob/master/src/bookCode/ch2/part1/ch2_part1DetailsUML.png)

#### 现在需要实现第三方报告板，相关代码如下：
``` java
//ThirdPartyDisplayImpl：第三方展示板
public class ThirdPartyDisplayImpl implements IObserver,IDisplayElement{

	private ISubject iSubject;
	private IObserver iObserver;
	
	private float temp;
	private float humidity;
	private float pressure;
	
	public ThirdPartyDisplayImpl(ISubject iSubject) {//向上转型
		this.iSubject = iSubject;
		iSubject.registerObservers(this);//this = ThirdPartyDisplayImpl
	}
	
	@Override
	public void display() {
		System.out.println("自己实现的第三方的展示板是："+temp+"度"+humidity+"湿度！！！！！");
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		display();//更新信息后需要调用展示方法
	}
}

输出结果：
CurrentConditionsDisplayImp : 1.0 度 and 78.0 湿度
Avg/Max/Min temperature = 1.0/1.0/1.0
Forecast: Improving weather on the way!
自己实现的第三方的展示板是：1.0度78.0湿度！！！！！
CurrentConditionsDisplayImp : 9.0 度 and 90.0 湿度
Avg/Max/Min temperature = 5.0/9.0/1.0
Forecast: Improving weather on the way!
自己实现的第三方的展示板是：9.0度90.0湿度！！！！！
CurrentConditionsDisplayImp : 10.0 度 and 100.0 湿度
Avg/Max/Min temperature = 6.6666665/10.0/1.0
Forecast: Improving weather on the way!
自己实现的第三方的展示板是：10.0度100.0湿度！！！！！

```

### 以上是手动实现的观察者模式，其实Java也有内置的观察者模式~~ 留意下一章~~



