package bookCode.ch4.part1;

/**
 * 意大利腊肉味
 * @author liquanliang
 *
 */
public class PepperoniPizza implements Pizza{

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
