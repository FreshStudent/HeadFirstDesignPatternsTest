package bookCode.ch4.part3.stores;

import bookCode.ch4.part3.factorys.BeiJingPizzaFactory;
import bookCode.ch4.part3.pizza.Pizza;

public class BeiJingPizzaStore {
	BeiJingPizzaFactory factory = new BeiJingPizzaFactory();
	
	public BeiJingPizzaStore(BeiJingPizzaFactory factory) {
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
