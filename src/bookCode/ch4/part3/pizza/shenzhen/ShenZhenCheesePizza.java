package bookCode.ch4.part3.pizza.shenzhen;
import bookCode.ch4.part3.pizza.Pizza;
/**
 * 芝士味
 * @author liquanliang
 *
 */
public class ShenZhenCheesePizza implements Pizza{

	@Override
	public void prepare() {
		System.out.println("CheesePizza prepare!");
	}

	@Override
	public void cut() {
		System.out.println("CheesePizza cut!");
	}

	@Override
	public void box() {
		System.out.println("CheesePizza box!");
	}

}
