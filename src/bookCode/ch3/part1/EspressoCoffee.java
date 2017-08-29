package bookCode.ch3.part1;

//浓缩咖啡
public class EspressoCoffee extends AbstractBeverage{

	public EspressoCoffee() {
		description = "Espresso Coffee";
	}
	
	@Override
	public double cost() {
		return 1.99;
	}
	

}
