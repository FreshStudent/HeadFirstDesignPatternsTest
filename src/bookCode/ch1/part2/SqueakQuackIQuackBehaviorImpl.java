package bookCode.ch1.part2;

public class SqueakQuackIQuackBehaviorImpl implements IQuackBehavior{
	
	//吱吱叫
	@Override
	public void quack() {
		System.out.println("<< Squeak！ 吱吱叫 >>");
	}
}
