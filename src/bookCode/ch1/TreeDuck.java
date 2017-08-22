package bookCode.ch1;

public class TreeDuck extends Duck{
	
	public static void main(String args[]) {
		
		TreeDuck treeDuck = new TreeDuck();
		treeDuck.quack();
		treeDuck.swin();
		treeDuck.display();
		
		//需要会飞
		treeDuck.fly();
		
	}

	@Override
	public void quack() {  //木头做的鸭子，确实不会叫啊
		System.out.println("这是木头做的的鸭子啊，不会叫的啊！！！！");
	}
	
	
	@Override
	public void display() {
		System.out.println("这是木头做的的鸭子啊，傻逼！");
	}
	
	@Override
	public void fly() {
		System.out.println("这是木头做的的鸭子啊，不会飞的啊！！！！");
	}

}
