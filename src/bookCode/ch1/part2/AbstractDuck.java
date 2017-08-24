package bookCode.ch1.part2;

/**
 * 父类：AbstractDuck.java
 *
 */
public abstract class AbstractDuck {
	
	public void swin() {
		System.out.println("鸭子游啊游~~");
	};

	public abstract void display();//每个鸭子的表现形式都是不一样的，有些是黑色的，有些是白色的。

	//每只鸭子都会引用实现IQuackBehavior接口的对象
	IFlyBehavior iFlyBehavior;

	//父类中，开放设置“飞”行为接口的方法，提供给实现类调用，可以动态的修改行为，而不是在new构造函数中定义
	public void setIFlyBehavior(IFlyBehavior iFlyBehavior) {
		this.iFlyBehavior = iFlyBehavior;
	}


	//鸭子对象不亲自处理"飞"的行为，而是委托给iFlyBehavior引用的对象
	//当鸭子需要“飞”的时候，直接委托给iFlyBehavior这个对象即可
	public void performFly() {
		iFlyBehavior.fly();
	}
	
	//每只鸭子都会引用实现IQuackBehavior接口的对象
	IQuackBehavior iQuackBehavior;
	
	//父类中，开放设置“叫”行为接口的方法，提供给实现类调用，可以动态的修改行为，而不是在new构造函数中定义
	public void setIQuackBehavior(IQuackBehavior iQuackBehavior) {
		this.iQuackBehavior = iQuackBehavior;
	}
	
	//鸭子对象不亲自处理呱呱叫的行为，而是委托给iQuackBehavior引用的对象
	//当鸭子需要“叫”的时候，直接委托给iQuackBehavior这个对象即可
	public void performQuack() {
		iQuackBehavior.quack();
	}
	
	
}
