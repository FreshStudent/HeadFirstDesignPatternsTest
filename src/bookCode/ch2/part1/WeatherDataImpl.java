package bookCode.ch2.part1;

import java.util.ArrayList;

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
