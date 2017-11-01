package bookCode.ch4.part3.pizza.guangzhou;
import bookCode.ch4.part3.pizza.Pizza;
/**
 * 希腊口味
 * @author liquanliang
 *
 */
public class GuangZhouGreekPizza implements Pizza{

	@Override
	public void prepare() {
		System.out.println("GuangZhou GreekPizza prepare!");
	}

	@Override
	public void cut() {
		System.out.println("GuangZhou GreekPizza cut!");
	}

	@Override
	public void box() {
		System.out.println("GuangZhou GreekPizza box!");
	}

}
