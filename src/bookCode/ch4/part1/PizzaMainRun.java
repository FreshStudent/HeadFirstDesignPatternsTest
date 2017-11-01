package bookCode.ch4.part1;

public class PizzaMainRun {

	public static void main(String[] args) {
		
		orderPizza("cheese");
		
	}
	
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
	
}
