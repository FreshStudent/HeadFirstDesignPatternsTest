package bookCode.ch1.part1;

/**
 * 子类
 * RubberDuck.java 橡皮鸭子
 *
 */
public class RubberDuck extends Duck{
	
	public static void main(String args[]) {
		
		RubberDuck rubberDuck = new RubberDuck();
		rubberDuck.quack();
		rubberDuck.swin();
		rubberDuck.display();
		
		//实现父类的“飞”方法
		rubberDuck.fly();
		
	}
	
	@Override    
	public void display() { //重写父类的display方法。
		System.out.println("这是橡皮做的鸭子！");
	}
		
}
