package bookCode.ch3;
 
public class Whip extends CondimentDecorator {
	AbstractBeverage beverage;
 
	public Whip(AbstractBeverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}
 
	public double cost() {
		return .10 + beverage.cost();
	}
}
