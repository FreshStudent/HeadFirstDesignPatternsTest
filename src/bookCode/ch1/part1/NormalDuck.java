package bookCode.ch1.part1;


/**
 * 普通鸭子
 */
public class NormalDuck extends Duck{

	//每个鸭子的样子都是不一样的，这个是普通鸭子的样子
	@Override     
	public void display() {//重写父类的display（abstract）方法
		System.out.println("这是红色的鸭子样啊！");		
	}
	
	public static void main(String args[]) {
		
		NormalDuck normalDuck = new NormalDuck();
		normalDuck.swin();
		normalDuck.quack();
		normalDuck.display();
		
	}
	
}
