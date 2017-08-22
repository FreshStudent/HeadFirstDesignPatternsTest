package bookCode.ch1.part1;

public class TreeDuck extends Duck{
	
	public static void main(String args[]) {
		
		TreeDuck treeDuck = new TreeDuck();
		treeDuck.quack();
		treeDuck.swin();
		treeDuck.display();
		treeDuck.fly();
		
	}
	
	@Override
	public void display() {
		System.out.println("这是木头做的鸭子啊，傻逼！");
	}

	
	//问题又来了，这个木头做的鸭子不会飞啊、并且也不会叫
	
	
}
