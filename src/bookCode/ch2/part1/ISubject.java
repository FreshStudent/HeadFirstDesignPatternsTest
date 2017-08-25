package bookCode.ch2.part1;

public interface ISubject {
	
	public void registerObservers(IObserver o);
	
	public void removeObservers(IObserver o);
	
	public void notifyObservers();

}
