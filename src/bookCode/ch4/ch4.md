## Chapter 04 the factory pattern 第04章 工厂模式
 
**ch4.part1**

![类UML图](https://github.com/FreshStudent/HeadFirstDesignPatternsTest/blob/master/src/bookCode/ch4/part1/ch4_part1UML.png)

ch4_part1:  
主要是模拟了创建Pizza的店，需要根据传入的type来new生成不同的披萨，但是由于type会在以后的日子里不断扩展，所以，直接在Pizza类中生成Pizza不是一个好办法，因为if...elsez是一个可变的方法，可以抽取出来，成为一个“工厂”。  

``` java
public static Pizza orderPizza(String type) {
	Pizza pizza = null;
	
	// if else这段代码是生产不同口味的Pizza的
	if("cheese".equals(type)) {
		pizza = new CheesePizza();
	}else if("greek".equals(type)) {
		pizza = new GreekPizza();
	}else if("pepperoni".equals(type)) {
		pizza = new PepperoniPizza();
	}
	//如果有更多的口味的Pizza，那么这段代码就要无限的增加，维护起来很麻烦，new xxxx 这是可变部分
	
	// 以下3个步骤，都是“不变”的部分，因此考虑把变动的抽取处理
	pizza.prepare();
	pizza.cut();
	pizza.box();
	
	return pizza;
		
}

```


**ch4.part2**

![类UML图](https://github.com/FreshStudent/HeadFirstDesignPatternsTest/blob/master/src/bookCode/ch4/part2/ch4_part2UML.png)

ch4_part2:  
抽取可变代码为工厂、零售店、Pizza三部分


``` java
//工厂
public class PizzaSimpleFactory {

	public Pizza createPizza(String type) {
		
		Pizza pizza = null;
		
		// if else这段代码是生产不同口味的Pizza的
		if("cheese".equals(type)) {
			pizza = new CheesePizza();
		}else if("greek".equals(type)) {
			pizza = new GreekPizza();
		}else if("pepperoni".equals(type)) {
			pizza = new PepperoniPizza();
		}
		return pizza;
	}	
}

```

``` java
// 零售店
public class PizzaStore {
	PizzaSimpleFactory factory = new PizzaSimpleFactory();
	
	public PizzaStore(PizzaSimpleFactory factory) {
		this.factory = factory;
	}
	
	public Pizza orderPizza(String type) {
		
		Pizza pizza = null;
		//由工厂新建Pizza		
		pizza = factory.createPizza(type);
		pizza.prepare();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}
}

```

``` java

//Pizza接口
public interface Pizza {
	public void prepare() ;
	public void cut() ;
	public void box() ;	
}

/**
 * 芝士味Pizza
 * @author lql
 *
 */
public class CheesePizza implements Pizza{

	@Override
	public void prepare() {
		System.out.println("CheesePizza prepare!");
	}

	@Override
	public void cut() {
		System.out.println("CheesePizza cut!");
	}

	@Override
	public void box() {
		System.out.println("CheesePizza box!");
	}

}

Greek、pepperoni味的Pizza代码略。。。。
..........

```

``` java

//Main 运行类 
public class PizzaMainRun {

	public static void main(String[] args) {
		
		//工厂
		PizzaSimpleFactory factory = new PizzaSimpleFactory();
		
		//销售Pizza的商店
		PizzaStore store = new PizzaStore(factory);
		
		//售卖芝士的Pizza
		store.orderPizza("cheese");
		
     }
}


```

---

**ch4.part3**

![类UML图](https://github.com/FreshStudent/HeadFirstDesignPatternsTest/blob/master/src/bookCode/ch4/part3/ch4_part3UML.png)

ch4_part3:  
抽取可变代码为工厂、零售店、Pizza三部分，然后，目前需要增加广州、深圳、北京3个工厂，这3个工厂生产的Pizza口味不一样，所以需要各自厂家生产各自的东西。

关键代码：  
  
``` java

public class PizzaMainRun {

	public static void main(String[] args) {
		
		//工厂
		GuangZhouPizzaFactory gzFactory = new GuangZhouPizzaFactory();
		ShenZhenPizzaFactory szFactory = new ShenZhenPizzaFactory();
		BeiJingPizzaFactory bjFactory = new BeiJingPizzaFactory();
		
		//销售Pizza的商店
		GuangZhouPizzaStore gzStore = new GuangZhouPizzaStore(gzFactory);
		ShenZhenPizzaStore szStore = new ShenZhenPizzaStore(szFactory);
		BeiJingPizzaStore bjStore = new BeiJingPizzaStore(bjFactory);
		
		//售卖芝士的Pizza
		gzStore.orderPizza("cheese");
		szStore.orderPizza("cheese");
		bjStore.orderPizza("cheese");
		
     }
} 

运行结果：
GuangZhou CheesePizza prepare!
GuangZhou CheesePizza cut!
GuangZhou CheesePizza box!
CheesePizza prepare!
CheesePizza cut!
CheesePizza box!
BeiJing CheesePizza prepare!
BeiJing CheesePizza cut!
BeiJing CheesePizza box!

```

到156 页，看不下去了 先缓一缓

**ch4.part4**

![类UML图](https://github.com/FreshStudent/HeadFirstDesignPatternsTest/blob/master/src/bookCode/ch4/part3/ch4_part3UML.png)

ch4_part3:  
抽取可变代码为工厂、零售店、Pizza三部分，然后，目前需要增加广州、深圳、北京3个工厂，这3个工厂生产的Pizza口味不一样，所以需要各自厂家生产各自的东西。


