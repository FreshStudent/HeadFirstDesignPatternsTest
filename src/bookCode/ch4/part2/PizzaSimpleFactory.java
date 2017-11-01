package bookCode.ch4.part2;

import bookCode.ch4.part2.CheesePizza;
import bookCode.ch4.part2.GreekPizza;
import bookCode.ch4.part2.PepperoniPizza;
import bookCode.ch4.part2.Pizza;

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
