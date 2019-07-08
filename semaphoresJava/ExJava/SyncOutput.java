import java.util.concurrent.Semaphore;

class SyncOutput implements Runnable{
	Semaphore Sem;
	String msg;

	SyncOutput(Semaphore sem, String m){
		Sem = sem;
		msg = m;
	}

	public void run(){
		try{
			Sem.acquire();
			System.out.println(msg);
			Thread.sleep(10);

		}catch (Exception e){
			System.out.println("Falha");
		}
		Sem.release();
	}
}