package bookCode.ch3.part1;

//星巴兹咖啡
public class HouseBlend extends AbstractBeverage{

	public HouseBlend() {
		description = "House Blend coffee";
	}
	
	@Override
	public double cost() {
		return 0.89;
	}

}
