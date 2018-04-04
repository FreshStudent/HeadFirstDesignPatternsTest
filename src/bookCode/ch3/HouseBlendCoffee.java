package bookCode.ch3;

//星巴兹咖啡
public class HouseBlendCoffee extends AbstractBeverage{

	public HouseBlendCoffee() {
		description = "House Blend coffee";
	}
	
	@Override
	public double cost() {
		return 0.89;
	}

}
