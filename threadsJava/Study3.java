public class Study3 implements Runnable
{
	@Override
	public void run(){
		System.out.println("----> Thread name: " + Thread.currentThread().getName() +"\n");
		int max = 2000;
		int min = 100;
		int time = (int)(Math.random()*((max-min)+1))+min;

		System.out.println("Thread "+Thread.currentThread().getName()+ " sleep time: " + time);

		for(int i=0;i<10;i++){
			
			System.out.println("Thread "+Thread.currentThread().getName()+ " counting: " + i);
			
			try{

				Thread.sleep(time);
			
			}catch(InterruptedException e){
				throw new IllegalStateException(e);
			}
		}

		System.out.println("----> End of "+ Thread.currentThread().getName());
	}
}