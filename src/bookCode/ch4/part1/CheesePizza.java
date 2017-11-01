package bookCode.ch4.part1;

/**
 * 芝士味
 * @author liquanliang
 *
 */
public class CheesePizza implements Pizza{

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
