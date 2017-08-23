package bookCode.ch1.part2;

public class AllDuckShowMain {

	
	public static void main(String args[]) {
		
		//eg:  Inf inf = new InfImpl();
		AbstractDuck mallardDuck = new MallardDuck();   //MallardDuck:绿头鸭
		mallardDuck.display();
		mallardDuck.performFly();
		mallardDuck.performQuack();
		
		System.out.println("---------------");
		
		AbstractDuck modelDuck = new ModelDuck();   //ModelDuck:模型鸭子
		modelDuck.display();
		modelDuck.performFly();
		modelDuck.performQuack();
		System.out.println("---------------");
		
		//AbstractDuck modelDuck = new ModelDuck();为什么不直接写成 ModelDuck  duck = new ModelDuck(); ?
		/**
		 * 那是因为 Inf inf = new InfImpl();  表示 inf 是要实现 Inf 接口的意思，
		 * 等价于   inf -> new InfImpl();
		 */
		
	}
}
