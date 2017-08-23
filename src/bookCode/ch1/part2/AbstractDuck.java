package bookCode.ch1.part2;

/**
 * 父类：Duck.java
 *
 */
public abstract class AbstractDuck {
	
	public void swin() {
		System.out.println("鸭子游啊游~~");
	};

	public abstract void display();//每个鸭子的表现形式都是不一样的，有些是黑色的，有些是白色的。

	//每只鸭子都会引用实现IQuackBehavior接口的对象
	IFlyBehavior iFlyBehavior;
	
	//鸭子对象不亲自处理"飞"的行为，而是委托给iFlyBehavior引用的对象
	//当鸭子需要“飞”的时候，直接委托给iFlyBehavior这个对象即可
	public void performFly() {
		iFlyBehavior.fly();
	}
	
	//每只鸭子都会引用实现IQuackBehavior接口的对象
	IQuackBehavior iQuackBehavior;
	
	//鸭子对象不亲自处理呱呱叫的行为，而是委托给iQuackBehavior引用的对象
	//当鸭子需要“叫”的时候，直接委托给iQuackBehavior这个对象即可
	public void performQuack() {
		iQuackBehavior.quack();
	}
	
	
}
