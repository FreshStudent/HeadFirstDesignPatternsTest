package bookCode.ch1.part1;

/**
 * 子类
 * 诱饵鸭子 NormalDuck.java
 */
public class DecoyDuck extends Duck{

	@Override
	public void display() {
		System.out.println("这是诱饵鸭子模型，不会飞而且不会叫");
	}
	
	@Override
	public void quack() {
		//什么也不干，因为诱饵鸭子不会飞也不会叫。
	}

	@Override
	public void fly() {
		//什么也不干，因为诱饵鸭子不会飞也不会叫。
	}
	
public static void main(String args[]) {
		
	DecoyDuck decoyduck = new DecoyDuck();
		decoyduck.swin();
		decoyduck.quack();
		decoyduck.display();
			
		//实现父类的“飞”方法
		decoyduck.fly();
		
	}
}
