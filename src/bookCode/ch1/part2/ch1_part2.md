## Chapter 01 Intro to Design Patterns 第01章 设计模式入门

**ch1.Part2**  

### 2.Design Principle Program to an interface, not an implementation. (P11)
设计原则：针对接口编程，而不是针对实现编程。


#### 一、重写AbstractDuck接口
``` java
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
```

#### 二、编写IFlyBehavior接口,及两个实现类FlyWithWindsIFlyBehaviorImpl、FlyNoWayIFlyBehaviorImpl
``` java
/**
 *  定义鸭子飞行的接口类
 */
public interface IFlyBehavior {
	
	//接口定义一个飞的方法，需要实现类来实现
	public void fly();

}
```
--

``` java 
//会飞的实现类，给会飞的鸭子使用。
public class FlyWithWindsIFlyBehaviorImpl implements IFlyBehavior{

	//重写飞接口的fly方法
	@Override
	public void fly() {
		//实现接口中飞的方法
		System.out.println("I am Flying!");
	}
}
```
--
``` java
//不会飞的实现类，给不会飞的鸭子使用。
public class FlyNoWayIFlyBehaviorImpl implements IFlyBehavior{
	
	//重写飞接口的fly方法
	@Override
	public void fly() {
		//实现接口中飞的方法
		System.out.println("I can‘t Fly!");
	}
}
```
--
#### 三、编写IQuackBehavior接口,及两个实现类

``` java
/**
 *  定义鸭子叫的接口类
 *
 */
public interface IQuackBehavior {
	
	//接口定义一个叫的方法，需要实现类来实现
	public void quack();

}
```
--
``` java
//大叫，给会叫的鸭子使用的实现类
public class QuackIQuackBehaviorImpl implements IQuackBehavior{

	//重写接口中的叫的方法
	//大叫
	@Override
	public void quack() {
		System.out.println("Quack！");
	}

}
```
--
``` java
//吱吱叫，给会吱吱叫的鸭子使用的实现类
public class SqueakQuackIQuackBehaviorImpl implements IQuackBehavior{
	
	//吱吱叫
	@Override
	public void quack() {
		System.out.println("<< Squeak！ 吱吱叫 >>");
	}
}
```
--
``` java
//安静，给不会叫的鸭子使用
public class MuteQuackIQuackBehaviorImpl implements IQuackBehavior{
	
	//安静
	@Override
	public void quack() {
		System.out.println("<< Silence! >>");
	}

}
```

#### 四、展现鸭子的Main函数
``` java
public class AllDuckShowMain {
	
	public static void main(String args[]) {
		
		//绿头鸭
		//eg:  Inf inf = new InfImpl();
		AbstractDuck mallardDuck = new MallardDuck();   //对上转型，MallardDuck:绿头鸭
		mallardDuck.display();
		mallardDuck.performFly();
		mallardDuck.performQuack();
		
		System.out.println("---------------");
		
		//模型鸭
		AbstractDuck modelDuck = new ModelDuck();   //对上转型，ModelDuck:模型鸭子
		modelDuck.display();
		modelDuck.performFly();
		modelDuck.performQuack();
		
		System.out.println("---------------");
		
		//诱饵鸭
        AbstractDuck decoyDuck = new DecoyDuck();   //对上转型，DecoyDuck:诱饵鸭子  会叫不会飞
		decoyDuck.display();
		decoyDuck.performFly();
		decoyDuck.performQuack();		
		
		System.out.println("---------------");

	}
}

运行结果：
This is 绿头鸭！！
I am Flying!
Quack！
---------------
This is 模型鸭！！
I can‘t Fly!
<< Silence! >>
---------------
This is 诱饵鸭！！
I can‘t Fly!
Quack！
---------------

```
## 疑问：
``` java 
AbstractDuck modelDuck = new ModelDuck();
```
> 
> 为什么不直接写成如下形式呢？ 
> 
``` java 
ModelDuck  duck = new ModelDuck(); 		
```
>> 那是因为 Inf inf = new InfImpl();  表示 inf 是要实现 Inf 接口的意思，
等价于   inf -> new InfImpl(); 
>
>> AbstractDuck modelDuck = new ModelDuck();这是对上转型（实现类的“上”是接口，对上转型：限制只能使用父类定义好的方法，一般子类定义的方法都是比父类多）
>> 
```java
	AbstractDuck modelDuck = new ModelDuck();
	modelDuck.modelDuckSmile();   //报错！！  
``` 
>> 因为：modelDuckSmile()这个是子类的方法，父类是没有这个方法的，(向上转型)这样调用是会报错的；
>> 
> 简单来说：
> 
>> AbstractDuck modelDuck = new ModelDuck();
>> 
>> 就是利用向上转型，限制modelDuck【接口实现类】只能调用AbstractDuck【父类】中的方法。


---
### 思考：如果现在要实现诱饵鸭（DecoyDuck，不会飞，会叫），该怎么实现？
>
> 新建一个DecoyDuck类即可，继承AbstractDuck，对应选择不会飞、会叫实现类。
> 

```java
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
``` 
---
### 思考：
> 以上每只鸭子的类中都在构造方法中先定义好了具体的行为，例如飞的形式、叫的形式，那么问题来了，如果需要实现_飞一下又不飞呢_？
> 
> 原来的实现方式是，每只鸭子的【构造方法】中都先规定好了这只鸭子的行为，那么这只鸭子的行为早就被限定好了，只有一套行为实现模式。
> 
> 例如以下模型鸭的代码:
> 

```java
	//构造函数
	public ModelDuck(){
	    //鸭子中“叫”的行为，在父类中被委托到iQuackBehavior对象，于是，模型鸭子“叫”实现类是MuteQuackIQuackBehaviorImpl
		iQuackBehavior = new MuteQuackIQuackBehaviorImpl();  //模型鸭子不会叫
		//鸭子中“飞”的行为，在父类中被委托到iFlyBehavior对象，于是，模型鸭子“飞”实现类是FlyNoWayIFlyBehaviorImpl
		iFlyBehavior = new FlyNoWayIFlyBehaviorImpl(); //模型鸭子是不会飞的
	} 
``` 
> 其实每只鸭子的构造函数都是为了改变“iQuackBehavior”、“iFlyBehavior”这两个行为引用指向的实现类。
> 
> 如果需要动态的改变鸭子的行为呢？怎么做？
> 
> 设想：如果可以动态的改变“iQuackBehavior”、“iFlyBehavior”这两个行为引用指向的实现类，不就可以实现动态绑定行为了吗？
> 
> 步骤：
> > 1.在父类中定义setXXXBehavior方法，提供子类进行XXXBehavior相关行为的设置。
> > >这样就可以动态的改变行为接口（“iQuackBehavior”、“iFlyBehavior”）指向的实现类了.
> > 2.子类的鸭子实现函数体中，需要动态指定对应的实现类

#### 代码如下：
```java
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
```
相关的实现类：

```java
		AbstractDuck rocketDuck = new RocketDuck();   //对上转型，DecoyDuck:诱饵鸭子  会叫不会飞
		rocketDuck.display();
		rocketDuck.performFly();//原来的飞行模式
		rocketDuck.setIFlyBehavior(new FlyRocketIFlyBehaviorImpl());//动态设置新的飞行模式
		rocketDuck.performFly();//新的飞行模式
		rocketDuck.performQuack();
		
运行结果：
This is 火箭鸭！！
I can‘t Fly!
I Fly by Rocket!
<< Silence! >>
```	

### 相关类UML图：
![类UML图](https://github.com/FreshStudent/HeadFirstDesignPatternsTest/blob/master/src/bookCode/ch1/part2/ch1_part2UML.png)		

