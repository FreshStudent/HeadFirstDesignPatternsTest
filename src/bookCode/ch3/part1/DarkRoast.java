package bookCode.ch3.part1;

public class DarkRoast extends AbstractBeverage {
	public DarkRoast() {
		description = "Dark Roast Coffee";
	}
	
	@Override
	public double cost() {
		return .99;
	}
}

