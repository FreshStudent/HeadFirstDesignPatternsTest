package bookCode.ch1.part2;
/**
 *绿头鸭 
 *
 */
public class MallardDuck extends AbstractDuck{

	//构造函数
	public MallardDuck(){
		
		 //鸭子中“叫”的行为，在父类中被委托到iQuackBehavior对象，于是，绿头鸭子“叫”实现类是QuackIQuackBehaviorImpl
		iQuackBehavior = new QuackIQuackBehaviorImpl();  //Quack 叫
		
		//鸭子中“飞”的行为，在父类中被委托到iFlyBehavior对象，于是，绿头鸭子“飞”实现类是FlyWithWindsIFlyBehaviorImpl
		iFlyBehavior = new FlyWithWindsIFlyBehaviorImpl(); 
	}
	
	@Override
	public void display() {
		System.out.println("This is 绿头鸭！！");
	}
	
}
