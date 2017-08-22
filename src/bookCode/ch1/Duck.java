package bookCode.ch1;

public abstract class Duck {
	
	//每只鸭子都会叫和游泳，所以在父类中定义叫和游泳的方法
	public void quack() {
		System.out.println("呱呱叫~~");
	};
	
	public void swin() {
		System.out.println("鸭子游啊游~~");
	};
	
	public void fly() {
		System.out.println("鸭子都会飞啊  飞飞飞~~");
	};
	
	public abstract void display();//每个鸭子的表现形式都是不一样的，有些事黑色的，有些事白色的。

}
