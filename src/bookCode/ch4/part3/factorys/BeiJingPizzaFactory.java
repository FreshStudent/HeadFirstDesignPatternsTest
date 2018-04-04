package bookCode.ch4.part3.factorys;

import bookCode.ch4.part3.pizza.Pizza;
import bookCode.ch4.part3.pizza.beijing.BeiJIngGreekPizza;
import bookCode.ch4.part3.pizza.beijing.BeiJingCheesePizza;
import bookCode.ch4.part3.pizza.beijing.BeiJingPepperoniPizza;

public class BeiJingPizzaFactory {

	public Pizza createPizza(String type) {
		
		Pizza pizza = null;
		
		if("cheese".equals(type)) {
			pizza = new BeiJingCheesePizza();
		}else if("greek".equals(type)) {
			pizza = new BeiJIngGreekPizza();
		}else if("pepperoni".equals(type)) {
			pizza = new BeiJingPepperoniPizza();
		}
		return pizza;
	}
	
}
