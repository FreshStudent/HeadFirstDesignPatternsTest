package bookCode.ch4.part2;

public class PizzaStore {
	PizzaSimpleFactory factory = new PizzaSimpleFactory();
	
	public PizzaStore(PizzaSimpleFactory factory) {
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
