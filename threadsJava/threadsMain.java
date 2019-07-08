import java.util.Scanner;
public class threadsMain
	/*
	 * These studies were created in base on the tutorial avaiable in:
	 * https://www.callicoder.com/java-multithreading-thread-and-runnable-tutorial/
	 * https://www.callicoder.com/java-executor-service-and-thread-pool-tutorial/
	 * http://www.java2s.com/Code/Java/Threads/CatalogThreads.htm
	 * https://www.guru99.com/multithreading-java.html
	 */
{
	public static void main(String[] args) {
		System.out.println("Main thread: " + Thread.currentThread().getName() );

		int op = 0;
		Scanner in = new Scanner(System.in);

		System.out.println("Which study shall be executed ?");
		System.out.println("1 - Creating Threads using Thread class");
		System.out.println("2 - Creating Threads using Runnable");
		System.out.println("3 - Study over sleep()");
		System.out.println("4 - Study over join()");
		System.out.println("5 - Study over Executor Framework");
		System.out.println("6 - Study over Thread pool");
		System.out.println("7 - not done");
		System.out.println("10 - Exercice 1");
		System.out.print("\nChoice:");
		op = in.nextInt();

		switch(op)
		{
			case 1:
				study1Run();
				break;
			case 2:
				study2Run();
				break;
			case 3:
				study3Run();
				break;
			case 4:
				study4Run();
				break;
			case 5:
				study5Run();
				break;
			case 6:
				study6Run();
				break;
			case 7:
				study7Run();
				break;
			case 10:
				ex1();
				break;
			default:
				System.out.println("Invalid item");
		}
					
		System.out.println("\nEnd of "+ Thread.currentThread().getName()+"\n");
	}

	static public void study1Run()
	{
		// method extendind Thread class
		/*
		* This method is very limited, because when you extends the Thread class, you can't extend
		* any other class.
		*/
		System.out.println("\nCreating threads... ");
		Study1 t1 = new Study1();  // Extending the Thread class
		Study1 t2 = new Study1();  // Extending the Thread class

		System.out.println("Starting threads...");
		t1.start();
		t2.start();		
	}

	static public void study2Run()
	{
		// create a runnable
		System.out.println("\nCreating Runnable... ");
		Runnable runnable = new Study2();

		System.out.println("Creating threads... ");
		Thread t1 =  new Thread(runnable);
		Thread t2 =  new Thread(runnable);

		System.out.println("Starting threads...");
		t1.start();
		t2.start();	

	}

	static public void study3Run()
	{
		// A study over pausing the execution of a Thread using sleep() 
		System.out.println("\nCreating Runnable... ");
		Runnable runnable = new Study3();

		System.out.println("Creating threads... ");
		Thread t1 =  new Thread(runnable);
		Thread t2 =  new Thread(runnable);

		System.out.println("Starting threads...");
		t1.start();
		t2.start();
			 
	}

	static public void study4Run()
	{
		// Waiting for completion of another thread using join()
		// the same code of study3 will be used
		System.out.println("\nCreating Runnable... ");
		Runnable runnable = new Study3();

		System.out.println("Creating threads... ");
		Thread t1 =  new Thread(runnable);
		Thread t2 =  new Thread(runnable);

		System.out.println("Starting threads...");
		t1.start();

		System.out.println("Waiting for thread1 to finish");
		try{
			t1.join(); // withou the argument, it simply waits until t1 conclusion
			// t1.join(500); //wait for 500 ms
		}catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
		t2.start();
	}

	static public void study5Run()
	{
		Study5 s5 = new Study5();
		s5.s5Run();
	}

	static public void study6Run()
	{
		new Study6();
	}

	static public void study7Run()
	{
		// Stopping a thread in a safe way
		System.out.println("\nCreating Runnable... ");
		Runnable runnable = new Study7();

		System.out.println("Creating threads... ");
		Thread t1 =  new Thread(runnable);

		System.out.println("Starting threads...");
		t1.start();

		try{
			t1.join(500); //wait 500 ms until stop thread
		} catch(InterruptedException e){
			throw new IllegalStateException(e);
		}
		
	}

	static public void ex1()
	{
		String s;
		int candidate;
		Scanner in = new Scanner(System.in);
		System.out.println("Ex1 -> Check prime numbers in a list");

		System.out.print("\nEntre com os numeros: ");
		s = in.nextLine();

		for(int i = 0; i<s.length(); i++){
			candidate = Character.getNumericValue(s.charAt(i));
			if(candidate>0){
				Ex1 pc = new Ex1(candidate);
				pc.start();

				// use a pc.join() if you want sequential answers
			}
		}
		
		


	}

	
}