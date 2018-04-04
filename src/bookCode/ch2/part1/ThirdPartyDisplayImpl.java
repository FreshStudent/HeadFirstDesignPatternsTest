package bookCode.ch2.part1;

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
