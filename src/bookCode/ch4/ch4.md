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