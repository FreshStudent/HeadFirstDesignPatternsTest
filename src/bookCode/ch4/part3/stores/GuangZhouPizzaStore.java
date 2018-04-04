package bookCode.ch4.part3.stores;

import bookCode.ch4.part3.factorys.GuangZhouPizzaFactory;
import bookCode.ch4.part3.pizza.Pizza;

public class GuangZhouPizzaStore {
	GuangZhouPizzaFactory factory = new GuangZhouPizzaFactory();
	
	public GuangZhouPizzaStore(GuangZhouPizzaFactory factory) {
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
