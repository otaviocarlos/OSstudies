public class Study7 implements Runnable
{
	private volatile boolean stop = false;

	@Override
	public void run(){
		System.out.println("\nNot done yet");
	}
}