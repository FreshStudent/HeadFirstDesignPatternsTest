package bookCode.ch1.part2;

//诱饵鸭，会叫，不会飞
public class DecoyDuck extends AbstractDuck{

	//构造函数
	public DecoyDuck(){
		
		//鸭子中“叫”的行为，在父类中被委托到iQuackBehavior对象，于是，模型鸭子“叫”实现类是QuackIQuackBehaviorImpl
		iQuackBehavior = new QuackIQuackBehaviorImpl();  //诱饵鸭子会叫
		
		//鸭子中“飞”的行为，在父类中被委托到iFlyBehavior对象，于是，模型鸭子“飞”实现类是FlyNoWayIFlyBehaviorImpl
		iFlyBehavior = new FlyNoWayIFlyBehaviorImpl(); //诱饵鸭子是不会飞的
	}
	
	@Override
	public void display() {
		System.out.println("This is 诱饵鸭！！");
	}
	
}
