#### Chapter 01 Intro to Design Patterns 第01章 设计模式入门
 
##### 1. Design Principle Identify the aspects of your application that vary and separate them from what stays the same.  (P9)
设计原则：找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起。

---
#### 需求迭代：#
1、刚开始，需要做一个鸭子的模型，因为不同的鸭子都是会叫（quack）和会游泳（swim）的，只是每个鸭子长得（display）不一样。
###### 因此，父类duck中实现quack、swim（不需要变化的），子类实现display（不一样的）

``` java
public abstract class Duck {
	//每只鸭子都会叫和游泳，所以在父类中定义叫和游泳的方法
	public void quack() {
		System.out.println("呱呱叫~~");
	};
	public void swin() {
		System.out.println("鸭子游啊游~~");
	};
	//每个鸭子的表现形式都是不一样的，有些是黑色的，有些是白色的。
	public abstract void display();	
```
2、刚开始，需要做一个鸭子的模型，因为不同的鸭子都是会叫（quack）和会游泳（swim）的，只是每个鸭子长得（display）不一样。

