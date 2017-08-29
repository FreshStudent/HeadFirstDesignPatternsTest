package bookCode.ch3.part1;

public class Milk extends CondimentDecorator {
	AbstractBeverage beverage;

	public Milk(AbstractBeverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	public double cost() {
		return .10 + beverage.cost();
	}
}
 