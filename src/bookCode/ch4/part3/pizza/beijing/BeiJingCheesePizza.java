package bookCode.ch4.part3.pizza.beijing;

import bookCode.ch4.part3.pizza.Pizza;

/**
 * 芝士味
 * @author liquanliang
 *
 */
public class BeiJingCheesePizza implements Pizza{

	@Override
	public void prepare() {
		System.out.println("BeiJing CheesePizza prepare!");
	}

	@Override
	public void cut() {
		System.out.println("BeiJing CheesePizza cut!");
	}

	@Override
	public void box() {
		System.out.println("BeiJing CheesePizza box!");
	}

}
