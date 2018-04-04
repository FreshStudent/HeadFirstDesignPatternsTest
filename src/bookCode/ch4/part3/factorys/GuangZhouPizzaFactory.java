package bookCode.ch4.part3.factorys;

import bookCode.ch4.part3.pizza.Pizza;
import bookCode.ch4.part3.pizza.guangzhou.GuangZhouCheesePizza;
import bookCode.ch4.part3.pizza.guangzhou.GuangZhouGreekPizza;
import bookCode.ch4.part3.pizza.guangzhou.GuangZhouPepperoniPizza;

public class GuangZhouPizzaFactory {

	public Pizza createPizza(String type) {
		
		Pizza pizza = null;
		
		if("cheese".equals(type)) {
			pizza = new GuangZhouCheesePizza();
		}else if("greek".equals(type)) {
			pizza = new GuangZhouGreekPizza();
		}else if("pepperoni".equals(type)) {
			pizza = new GuangZhouPepperoniPizza();
		}
		return pizza;
	}
	
}
