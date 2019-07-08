public class Study2 implements Runnable
{
	/* Implementing Runnable */
	/* It defines a single method run(), which is meant to contain the code that is executed by the thread.*/
	@Override
	public void run()
	{
		System.out.println("Thread name: " + Thread.currentThread().getName() );
		System.out.println("End of "+ Thread.currentThread().getName());
	}
}