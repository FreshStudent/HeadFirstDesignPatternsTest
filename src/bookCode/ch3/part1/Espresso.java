package bookCode.ch3.part1;

//浓缩咖啡
public class Espresso extends AbstractBeverage{

	public Espresso() {
		description = "Espresso";
	}
	
	@Override
	public double cost() {
		return 1.99;
	}
	

}
