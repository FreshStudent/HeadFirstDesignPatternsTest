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



### 【观察者模式】总结：
- 设计原则：找出程序中会**_变化_**的方面，然后将其**_固定不变_**的方面**_相分离_**。
	- 在观察者模式中，会改变的是主题的状态，以及观察者的数目和类型。用这个模式，你可以改变依赖于主题的对象，却不必改变主题，这是“提前规划”！
- 设计原则：**_针对接口_**编程,不针对实现编程。
	- 主题和观察者都使用接口：观察者主要利用主题的接口向主题注册，而主题利用观察者接口通知观察者。这样使得两者之间运作正常，又同时具有松耦合的优点。

- 设计原则：**_多用接口，少用继承_**。
	- 观察者模式利用“组合”将许多观察者组合进主题中，对象之间的这种关系不是通过继承产生的，而是在运行时利用**_组合_**的方式而产生的。

