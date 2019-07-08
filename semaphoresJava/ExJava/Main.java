import java.util.concurrent.Semaphore;

public class Main{
	public static void main(String args[]) throws Exception{
		
		Semaphore S = new Semaphore(1, true);
		Thread t1 = new Thread(new SyncOutput(S,"Mensagem 1"));
		Thread t2 = new Thread(new SyncOutput(S,"Mensagem 2"));

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}
}