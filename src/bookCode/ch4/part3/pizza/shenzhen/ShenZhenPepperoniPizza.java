package bookCode.ch4.part3.pizza.shenzhen;
import bookCode.ch4.part3.pizza.Pizza;
/**
 * 意大利腊肉味
 * @author liquanliang
 *
 */
public class ShenZhenPepperoniPizza implements Pizza{

	@Override
	public void prepare() {
		System.out.println("PepperoniPizza prepare!");
	}

	@Override
	public void cut() {
		System.out.println("PepperoniPizza cut!");
	}

	@Override
	public void box() {
		System.out.println("PepperoniPizza box!");
	}

}
