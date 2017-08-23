package bookCode.ch1.part2;

public class ModelDuck extends AbstractDuck{

	//构造函数
	public ModelDuck(){
		
		 //鸭子中“叫”的行为，在父类中被委托到iQuackBehavior对象，于是，模型鸭子“叫”实现类是MuteQuackIQuackBehaviorImpl
		
		iQuackBehavior = new MuteQuackIQuackBehaviorImpl();  //模型鸭子不会叫
		
		//鸭子中“飞”的行为，在父类中被委托到iFlyBehavior对象，于是，模型鸭子“飞”实现类是FlyNoWayIFlyBehaviorImpl
		
		iFlyBehavior = new FlyNoWayIFlyBehaviorImpl(); //模型鸭子是不会飞的
	}
	
	@Override
	public void display() {
		System.out.println("This is 模型鸭！！");
	}
	
	public void modelDuckSmile() {
		System.out.println("This is 模型鸭在笑！！");		
	}
	
}
