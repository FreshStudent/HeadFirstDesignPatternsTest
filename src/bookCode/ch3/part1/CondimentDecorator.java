package bookCode.ch3.part1;

public abstract class CondimentDecorator extends AbstractBeverage{

	@Override
	public double cost() {
		return 0;
	}

	public abstract String getDescription() ;
}
