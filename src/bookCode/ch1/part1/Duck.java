package bookCode.ch1.part1;

/**
 * 父类：Duck.java
 *
 */
public abstract class Duck {
	
	//每只鸭子都会叫和游泳，所以在父类中定义叫和游泳的方法
	public void quack() {
		System.out.println("呱呱叫~~");
	};
	
	public void swin() {
		System.out.println("鸭子游啊游~~");
	};

	public abstract void display();//每个鸭子的表现形式都是不一样的，有些是黑色的，有些是白色的。

	
	//现在想让鸭子会飞，因此，按照原来的思路，在父类中写好fly方法即可
	public void fly() {
		System.out.println("鸭子飞飞飞~~");
		
	}
	
}
