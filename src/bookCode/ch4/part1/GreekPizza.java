package bookCode.ch4.part1;

/**
 * 希腊口味
 * @author liquanliang
 *
 */
public class GreekPizza implements Pizza{

	@Override
	public void prepare() {
		System.out.println("GreekPizza prepare!");
	}

	@Override
	public void cut() {
		System.out.println("GreekPizza cut!");
	}

	@Override
	public void box() {
		System.out.println("GreekPizza box!");
	}

}
