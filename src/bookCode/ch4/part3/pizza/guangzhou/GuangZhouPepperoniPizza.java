package bookCode.ch4.part3.pizza.guangzhou;
import bookCode.ch4.part3.pizza.Pizza;
/**
 * 意大利腊肉味
 * @author liquanliang
 *
 */
public class GuangZhouPepperoniPizza implements Pizza{

	@Override
	public void prepare() {
		System.out.println("GuangZhou PepperoniPizza prepare!");
	}

	@Override
	public void cut() {
		System.out.println("GuangZhou PepperoniPizza cut!");
	}

	@Override
	public void box() {
		System.out.println("GuangZhou PepperoniPizza box!");
	}

}
