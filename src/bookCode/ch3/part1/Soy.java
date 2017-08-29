package bookCode.ch3.part1;

public class Soy extends CondimentDecorator {
	AbstractBeverage beverage;

	public Soy(AbstractBeverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	public double cost() {
		double cost = beverage.cost();
		if(beverage.getSize() == Size.TALL) {
			cost = cost + 10.0;
		}if(beverage.getSize() == Size.MIDDLE) {
			cost = cost + 20.0;
		}else if(beverage.getSize() == Size.LARGE){
			cost = cost + 30.0;
		}
		return cost;
	}
	
	
}
