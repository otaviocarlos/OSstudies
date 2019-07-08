public class Study1 extends Thread
{ 
	/* Extending Thread class */
	@Override
	public void run()
	{
		System.out.println("Thread name: " + Thread.currentThread().getName() );
		System.out.println("End of "+ Thread.currentThread().getName());
	}
}