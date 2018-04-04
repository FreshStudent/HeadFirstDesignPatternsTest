package bookCode.ch1.part2;

//火箭鸭
public class RocketDuck extends AbstractDuck{
	//构造函数
	public RocketDuck(){
		iQuackBehavior = new MuteQuackIQuackBehaviorImpl();  //一开始是不会叫的
		iFlyBehavior = new FlyNoWayIFlyBehaviorImpl(); //一开始是不会飞的
	}
	@Override
	public void display() {
		System.out.println("This is 火箭鸭！！");
	}
}
