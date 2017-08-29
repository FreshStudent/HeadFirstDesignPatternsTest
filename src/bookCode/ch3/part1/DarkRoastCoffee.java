package bookCode.ch3.part1;

public class DarkRoastCoffee extends AbstractBeverage {
	public DarkRoastCoffee() {
		description = "Dark Roast Coffee";
	}
	
	@Override
	public double cost() {
		return .99;
	}
}

