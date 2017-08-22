#### Chapter 01 Intro to Design Patterns 第01章 设计模式入门
 
##### 1. Design Principle Identify the aspects of your application that vary and separate them from what stays the same.  (P9)
设计原则：找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起。

---
#### 需求迭代：#
一、刚开始，需要做一个鸭子的模型，有橡皮鸭子、红鸭子（普通鸭子）等，因为不同的鸭子都是会叫（quack）和会游泳（swim）的，只是每个鸭子长得（display）不一样，所以考虑利用**【继承】**来实现。
###### 因此，父类duck中实现quack、swim（不需要变化的），子类实现display（不一样的）

``` java
父类 ：Duck.java

/**
* 定义一个父类Duck.java，有叫和游泳的方法
**/

public abstract class Duck {
	
	//每只鸭子都会叫和游泳，所以在父类中定义叫和游泳的方法
	
	public void quack() {
		System.out.println("鸭子呱呱叫~~");
	};
	
	public void swin() {
		System.out.println("鸭子游啊游~~");
	};

   //每个鸭子的样子都是不一样的，有些是黑色的，有些是白色的，所以定义一个虚拟方法，便于继承的类实现。
	public abstract void display();	
	
}

```

``` java
子类：NormalDuck.java
/**
 * 普通鸭子  NormalDuck.java
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
```
``` java
子类：RubberDuck.java
/**
 * RubberDuck.java 橡皮鸭子
 *
 */
public class RubberDuck extends Duck{
	
	public static void main(String args[]) {
		RubberDuck rubberDuck = new RubberDuck();
		rubberDuck.quack();
		rubberDuck.swin();
		rubberDuck.display();		
	}
	
	@Override    
	public void display() { //重写父类的display方法。
		System.out.println("这是橡皮做的鸭子！");
	}
		
}

```
---
#### 个人理解：
##### 文字描述：
- 橡皮鸭子、普通鸭子都具有鸭子的共性：会叫、会游泳，只是每个鸭子的样子都长得不一样而已。

##### Java描述：
- 子类具有相同的属性，因此可以将共性作为父类抽取出来，利用【继承】即可减少重复代码；
- 针对不同的（例如外貌），需要在父类中定义一个抽象方法display，在子类中重写父类的display方法，并各自实现display。

2、刚开始，需要做一个鸭子的模型，因为不同的鸭子都是会叫（quack）和会游泳（swim）的，只是每个鸭子长得（display）不一样。

