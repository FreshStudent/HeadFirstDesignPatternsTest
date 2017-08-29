package bookCode.ch3.part1;

public abstract class AbstractBeverage {

	public enum Size{TALL,MIDDLE,LARGE};
	
	Size size = Size.TALL;
	
	String description = "Unknown Beverage!";
	
	public String getDescription() {
		return description;
	}

	public abstract double cost();
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public Size getSize() {
		return this.size;
	}
	
}
