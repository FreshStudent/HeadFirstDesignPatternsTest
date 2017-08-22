package bookCode.ch1;

public class RedDuck extends Duck{

	public static void main(String args[]) {
		
		RedDuck redDuck = new RedDuck();
		redDuck.swin();
		redDuck.quack();
		redDuck.display();
		
		//需要会飞
		redDuck.fly();
		
	}

	@Override
	public void display() {
		System.out.println("这是红色的鸭子啊，傻逼！");		
	}
	
}
