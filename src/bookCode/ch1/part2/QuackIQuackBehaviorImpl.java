package bookCode.ch1.part2;

public class QuackIQuackBehaviorImpl implements IQuackBehavior{

	//重写接口中的叫的方法
	@Override
	public void quack() {
		System.out.println("Quack！");
	}

}
