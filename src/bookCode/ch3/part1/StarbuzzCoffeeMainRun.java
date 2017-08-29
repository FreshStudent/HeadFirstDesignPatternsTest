package bookCode.ch3.part1;

import bookCode.ch3.part1.AbstractBeverage.Size;

public class StarbuzzCoffeeMainRun {
	
	public static void main(String args[]) {
		
		AbstractBeverage beverage = new EspressoCoffee();  //一杯EspressoCoffee，不需要任何调料，打印出它的描述和价钱
		System.out.println(beverage.getDescription()+" $ "+beverage.cost());
		
		AbstractBeverage beverage2 = new DarkRoastCoffee();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription()+" $ "+beverage2.cost());
		
		AbstractBeverage beverage3 = new HouseBlendCoffee();  //制造一个HouseBlendCoffee对象
		beverage3.setSize(Size.MIDDLE); //中杯
		beverage3 = new Soy(beverage3);   //用豆浆装饰它
		beverage3 = new Mocha(beverage3); //用摩卡装饰它
		beverage3 = new Whip(beverage3);  //用奶泡装饰它
		System.out.println(beverage3.getDescription()+" $ "+beverage3.cost());
		
		AbstractBeverage beverage4 = new DecafCoffee();  //制造一个DecafCoffee对象
		beverage4.setSize(Size.MIDDLE); //中杯
		beverage4 = new Soy(beverage4);   //豆浆
		beverage4 = new Mocha(beverage4); //摩卡
		beverage4 = new Whip(beverage4);  //奶泡
		System.out.println(beverage4.getDescription()+" $ "+beverage4.cost());
		
		AbstractBeverage beverage5 = new DecafCoffee();  //制造一个DecafCoffee对象
		beverage5.setSize(Size.LARGE); // 大杯
		beverage5 = new Soy(beverage5);   //豆浆
		beverage5 = new Mocha(beverage5); //摩卡
		beverage5 = new Whip(beverage5);  //奶泡
		System.out.println(beverage5.getDescription()+" $ "+beverage5.cost());
		
	}
}
