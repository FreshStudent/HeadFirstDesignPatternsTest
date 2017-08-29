package bookCode.ch3.part1;

public class Mocha extends CondimentDecorator{
	
	AbstractBeverage beverage;
	
	public Mocha(AbstractBeverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription()+", Mocha";
	}
	
	public double cost() {
		return .20+beverage.cost();
	}
	
}
