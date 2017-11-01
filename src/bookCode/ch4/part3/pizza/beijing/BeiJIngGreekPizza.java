package bookCode.ch4.part3.pizza.beijing;

import bookCode.ch4.part3.pizza.Pizza;

/**
 * 希腊口味
 * @author liquanliang
 *
 */
public class BeiJIngGreekPizza implements Pizza{

	@Override
	public void prepare() {
		System.out.println("BeiJIng GreekPizza prepare!");
	}

	@Override
	public void cut() {
		System.out.println("BeiJIng GreekPizza cut!");
	}

	@Override
	public void box() {
		System.out.println("BeiJIng GreekPizza box!");
	}

}
