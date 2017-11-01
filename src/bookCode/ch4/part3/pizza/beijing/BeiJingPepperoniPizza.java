package bookCode.ch4.part3.pizza.beijing;
import bookCode.ch4.part3.pizza.Pizza;
/**
 * 意大利腊肉味
 * @author liquanliang
 *
 */
public class BeiJingPepperoniPizza implements Pizza{

	@Override
	public void prepare() {
		System.out.println("BeiJing PepperoniPizza prepare!");
	}

	@Override
	public void cut() {
		System.out.println("BeiJing PepperoniPizza cut!");
	}

	@Override
	public void box() {
		System.out.println("BeiJing PepperoniPizza box!");
	}

}
