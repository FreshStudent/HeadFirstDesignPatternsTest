package bookCode.ch3;

public abstract class CondimentDecorator extends AbstractBeverage{

	@Override
	public double cost() {
		return 0;
	}

	public abstract String getDescription() ;
}
