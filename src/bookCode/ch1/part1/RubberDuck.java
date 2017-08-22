package bookCode.ch1.part1;

/**
 * RubberDuck.java 橡皮鸭子
 *
 */
public class RubberDuck extends Duck{
	
	public static void main(String args[]) {
		
		RubberDuck rubberDuck = new RubberDuck();
		rubberDuck.quack();
		rubberDuck.swin();
		rubberDuck.display();
		
		
	}
	
	@Override    
	public void display() { //重写父类的display方法。
		System.out.println("这是橡皮做的鸭子！");
	}
		
}
