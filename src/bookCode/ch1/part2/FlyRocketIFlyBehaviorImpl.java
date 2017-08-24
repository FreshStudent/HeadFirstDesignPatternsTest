package bookCode.ch1.part2;

public class FlyRocketIFlyBehaviorImpl implements IFlyBehavior{

	//重写飞接口的fly方法
	@Override
	public void fly() {
		
		//实现接口中飞的方法
		System.out.println("I Fly by Rocket!");
		
	}

}
