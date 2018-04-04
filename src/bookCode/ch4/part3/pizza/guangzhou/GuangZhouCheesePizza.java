package bookCode.ch4.part3.pizza.guangzhou;
import bookCode.ch4.part3.pizza.Pizza;
/**
 * 芝士味
 * @author liquanliang
 *
 */
public class GuangZhouCheesePizza implements Pizza{

	@Override
	public void prepare() {
		System.out.println("GuangZhou CheesePizza prepare!");
	}

	@Override
	public void cut() {
		System.out.println("GuangZhou CheesePizza cut!");
	}

	@Override
	public void box() {
		System.out.println("GuangZhou CheesePizza box!");
	}

}
