package bookCode.ch4.part3.stores;

import bookCode.ch4.part3.factorys.ShenZhenPizzaFactory;
import bookCode.ch4.part3.pizza.Pizza;

public class ShenZhenPizzaStore {
	ShenZhenPizzaFactory factory = new ShenZhenPizzaFactory();
	
	public ShenZhenPizzaStore(ShenZhenPizzaFactory factory) {
		this.factory = factory;
	}
	
	public Pizza orderPizza(String type) {
		
		Pizza pizza = null;
		
		pizza = factory.createPizza(type);
		pizza.prepare();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}
}
