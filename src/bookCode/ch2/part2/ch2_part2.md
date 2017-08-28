## Chapter 02 the observer pattern 第02章 观察者模式
 
**ch2.part2**
 
### 利用Java内置对象实现观察者模式



---
![类UML图](https://github.com/FreshStudent/HeadFirstDesignPatternsTest/blob/master/src/bookCode/ch2/part2/ch2_part2UML.png)

``` java


WeatherDate.java

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
```

```java

interface:IDisplayElement.java

public interface IDisplayElement {
	public void display();
}


```

``` java
import java.util.Observer;
import java.util.Observable;

//CurrentConditionsDisplayImpl：目前状况报告版
public class CurrentConditionsDisplayImpl implements Observer,IDisplayElement{
	Observable observable;
	private float temperature;
	private float humidity;
	
	public CurrentConditionsDisplayImpl(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}
	
	@Override
	public void update(Observable obs, Object arg) {
		if(obs instanceof WeatherDate) {
			WeatherDate weatherDate = (WeatherDate)obs;
			this.temperature = weatherDate.getTemperature();
			this.humidity = weatherDate.getHumidity();
			display();
		}
	}
	
	@Override
	public void display() {
		System.out.println("CurrentConditionsDisplayImpl : " +temperature+" F degrees and "+humidity +" %humidity");
	}
}



其他报告版略。。。。。。。
```


``` java
输出结果:
自己实现的第三方的展示板是：1.0度78.0湿度！！！！！
Forecast: Improving weather on the way!
Avg/Max/Min temperature = 1.0/1.0/1.0
CurrentConditionsDisplayImpl : 1.0 F degrees and 78.0 %humidity
自己实现的第三方的展示板是：10.0度100.0湿度！！！！！
Forecast: Improving weather on the way!
Avg/Max/Min temperature = 5.5/11.0/1.0
CurrentConditionsDisplayImpl : 10.0 F degrees and 100.0 %humidity
```
#### 为什么输出的结果会是倒序的呢？
> 使用java.util.Observable的话，因为他甚至没有实现一个接口，这样就限制了他的使用和复用。<br>
> 因为继承了java内置对象Observer对象，它是一个“类”，不是一个接口，作为类，就必须要继承它，才可以对它实现扩充，如果想继承A类、B类两个类的话，java估计无法实现这个，因为java不支持多重继承。<br>



