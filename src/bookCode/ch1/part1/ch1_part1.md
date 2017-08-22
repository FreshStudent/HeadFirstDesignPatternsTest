#### Chapter 01 Intro to Design Patterns 第01章 设计模式入门
 
##### 1. Design Principle Identify the aspects of your application that vary and separate them from what stays the same.  (P9)
设计原则：找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起。

---
#### 需求迭代：
一、Boss们想做一些鸭子：
> Boss：需要做一个鸭子的模型，有橡皮鸭子、红鸭子（普通鸭子）等。
> 
> Lee：因为不同的鸭子都是会叫（quack）和会游泳（swim）的，只是每个鸭子样子长得（display）不一样，所以考虑利用**【继承】**来实现
>
>因此，父类duck中实现quack、swim（不需要变化的），子类实现display（不一样的）；

``` java
父类 ：Duck.java

/**
* 定义一个父类Duck.java，有叫和游泳的实现 方法
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

二、Boss们想要做出来的鸭子会飞的：
> Boss：目前做出来的鸭子，需要可以飞的。
> 
> Lee：会飞是吧？行啊，直接在继承类中增加“飞”的方法就行了！
> 
>因此，父类duck中实现添加fly方法：

``` java
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

	//每个鸭子的表现形式都是不一样的，有些是黑色的，有些是白色的。
	public abstract void display();
		
	//现在想让鸭子会飞，因此，按照原来继承的思路，在父类中写好fly方法即可
	public void fly() {
		System.out.println("鸭子飞飞飞~~");
		
	}
	
}

```

``` java
/**
 * 子类
 * 普通鸭子 NormalDuck.java
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
		
		//实现父类的“飞”方法
		normalDuck.fly();
		
	}
	
}

运行效果：
鸭子游啊游~~
呱呱叫~~
这是红色的鸭子样啊！
鸭子飞飞飞~~
```

``` java
/**
 * 子类
 * RubberDuck.java 橡皮鸭子
 *
 */
public class RubberDuck extends Duck{
	
	public static void main(String args[]) {
		
		RubberDuck rubberDuck = new RubberDuck();
		rubberDuck.quack();
		rubberDuck.swin();
		rubberDuck.display();
		
		//实现父类的“飞”方法
		rubberDuck.fly();
		
	}
	
	@Override    
	public void display() { //重写父类的display方法。
		System.out.println("这是橡皮做的鸭子！");
	}
		
}


```
> 经过一番折腾，Lee终于把代码写好了，并且提交了
> 
> 下周一上班后，Lee被叫去办公室了。
> 
> Boos训斥说：我说的所有鸭子会飞，那么请问橡皮鸭子也能飞吗？？？？？？
> 
> Lee想了一下，确实，实现利用继承来实现鸭子模型，确实比较方便，但是也会存在以上Boss所说的问题，那么只要将不能飞的鸭子重写父类方法但是不具体实现就好了
>

``` java
RubberDuck.java

fly(){
  //什么也不做
}

```
> 过了一段时间，Boss们又需要增加各种鸭子，有些鸭子会飞，有些不会，其中就有钓鱼用的诱饵鸭（不会飞、不会叫），这就需要DecoyDuck.java子类重写父类的quark方法、fly方法，还是之前的套路，只是重写，并没有具体的实现。

``` java
DecoyDuck.java
/**
 * 子类
 * 诱饵鸭子 NormalDuck.java
 */
public class DecoyDuck extends Duck{

	@Override
	public void display() {
		System.out.println("这是诱饵鸭子模型，不会飞而且不会叫");
	}
	
	@Override
	public void quack() {
		//什么也不干，因为诱饵鸭子不会飞也不会叫。
	}

	@Override
	public void fly() {
		//什么也不干，因为诱饵鸭子不会飞也不会叫。
	}
	
public static void main(String args[]) {
		
	DecoyDuck decoyduck = new DecoyDuck();
		decoyduck.swin();
		decoyduck.quack();
		decoyduck.display();
			
		//实现父类的“飞”方法
		decoyduck.fly();
		
	}
}

程序运行效果：
鸭子游啊游~~
这是诱饵鸭子模型，不会飞而且不会叫


```


> 以后，可能有更多不同的鸭子模型需要实现，部分需要会叫、会飞，部分会飞、不会叫，部分不会飞也不会叫，那么，每一次都需要排查新加入的鸭子是否会飞，或者是否会叫，每一次新的子类都需要重写父类的方法，而且看情况决定重写的方法是否有具体的实现（会不会飞、会不会叫）。这样会不会疯？？？？？
> 
> 能不能把叫、飞这些动作提取出来，会飞的鸭子模型才实现“飞”这个动作，会叫的鸭子才实现“叫”这个动作呢？
 
---

## 思考：父类Duck.java中的abstract的display方法，是不是和面向接口编程（先定义接口方法，实现类impl再实现接口方法）有点像呢？

## 确实很像，但是又有所不同。
>
>
> #### **抽象类和接口的区别：**
> 
> 抽象类含义：
> 抽象类是用来捕捉子类的通用特性的 。它不能被实例化，只能被用作<font color=red face="微软雅黑">**子类**</font>的<font color=red face="微软雅黑">**超类**</font>。抽象类是被用来创建继承层级里<font color=red face="微软雅黑">**子类**</font>的模板。
> 
> 接口含义：
> 接口是抽象方法的集合。如果一个类实现了某个接口，那么它就继承了这个接口的抽象方法。这就像契约模> 式，如果<font color=red face="微软雅黑">**实现**</font>了这个接口，那么就<font color=red face="微软雅黑">**必须**</font>确保<font color=red face="微软雅黑">**使用这些方法**</font>。

---
#### **什么时候使用抽象类和接口**

- 如果你拥有一些方法并且想让它们中的一些有默认实现，那么使用抽象类吧。
- 如果你想实现多重继承，那么你必须使用接口。由于Java不支持多继承，子类不能够继承多个类，但可以实现多个接口。因此你就可以使用接口来解决它。
- 如果基本功能在不断改变，那么就需要使用抽象类。
- 如果不断改变基本功能并且使用接口，那么就需要改变所有实现了该接口的类。