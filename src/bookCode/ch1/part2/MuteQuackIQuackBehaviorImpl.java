package bookCode.ch1.part2;

public class MuteQuackIQuackBehaviorImpl implements IQuackBehavior{
	
	//安静
	@Override
	public void quack() {
		System.out.println("<< Silence! >>");
	}

}
