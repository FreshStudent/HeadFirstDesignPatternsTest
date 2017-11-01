package bookCode.ch4.part3.factorys;

import bookCode.ch4.part3.pizza.Pizza;
import bookCode.ch4.part3.pizza.shenzhen.ShenZhenCheesePizza;
import bookCode.ch4.part3.pizza.shenzhen.ShenZhenGreekPizza;
import bookCode.ch4.part3.pizza.shenzhen.ShenZhenPepperoniPizza;

public class ShenZhenPizzaFactory {

	public Pizza createPizza(String type) {
		
		Pizza pizza = null;
		
		// if else这段代码是生产不同口味的Pizza的
		if("cheese".equals(type)) {
			pizza = new ShenZhenCheesePizza();
		}else if("greek".equals(type)) {
			pizza = new ShenZhenGreekPizza();
		}else if("pepperoni".equals(type)) {
			pizza = new ShenZhenPepperoniPizza();
		}
		return pizza;
	}
	
}
