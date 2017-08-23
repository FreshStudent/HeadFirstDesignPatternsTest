package bookCode.ch1.part2;

public class AllDuckShowMain {
	
	public static void main(String args[]) {
		
		//eg:  Inf inf = new InfImpl();
		AbstractDuck mallardDuck = new MallardDuck();   //对上转型，MallardDuck:绿头鸭
		mallardDuck.display();
		mallardDuck.performFly();
		mallardDuck.performQuack();
		
		System.out.println("---------------");
		
		AbstractDuck modelDuck = new ModelDuck();   //对上转型，ModelDuck:模型鸭子
		modelDuck.display();
		modelDuck.performFly();
		modelDuck.performQuack();
		
		//AbstractDuck modelDuck = new ModelDuck();这是对上转型（实现类的“上”是接口，对上转型：限制只能使用父类定义好的方法，一般子类定义的方法都是比父类多的，）
		//modelDuck.modelDuckSmile();   //报错！！！！   modelDuckSmile()这个是子类的方法，这样调用是会报错的；
		
		//ModelDuck modelDuck = new ModelDuck();
		//modelDuck.modelDuckSmile();   //不报错
		
		System.out.println("---------------");
		
		//AbstractDuck modelDuck = new ModelDuck();为什么不直接写成 ModelDuck  duck = new ModelDuck(); 
		/**
		 * 那是因为 Inf inf = new InfImpl();  表示 inf 是要实现 Inf 接口的意思，
		 * 等价于   inf -> new InfImpl(); 
		 * AbstractDuck modelDuck = new ModelDuck();这是对上转型（实现类的“上”是接口，对上转型：限制只能使用父类定义好的方法，一般子类定义的方法都是比父类多的，）
		 * modelDuck.modelDuckSmile();   //报错！！   因为：modelDuckSmile()这个是子类的方法，父类是没有这个方法的，这样调用是会报错的；
		 * 
		 */
		
	}
}
