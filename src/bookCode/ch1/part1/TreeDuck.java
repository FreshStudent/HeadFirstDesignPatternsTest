package bookCode.ch1.part1;

public class TreeDuck extends Duck{
	
	public static void main(String args[]) {
		
		TreeDuck treeDuck = new TreeDuck();
		treeDuck.quack();
		treeDuck.swin();
		treeDuck.display();
		
	}
	
	@Override
	public void display() {
		System.out.println("这是木头做的的鸭子啊，傻逼！");
	}

}
