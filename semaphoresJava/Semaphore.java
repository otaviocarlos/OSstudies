public class Semaphore{
	private int value;
	public Semaphore(){
		value = 0;
	}

	public Semaphore(int value){
		this.value = value;
	}

	public synchronized void down(){
		while(value==0){
			try{
				wait();
			}catch(InterruptedException e){  } // do nothing
		}

		value--;
	}

	public synchronized void up(){
		value++;
		notify();
	}

}