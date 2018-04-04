package bookCode.ch4.part2;

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
