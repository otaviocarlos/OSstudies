import java.util.concurrent.Semaphore;

class Queue{
	int value;
	static Semaphore con = new Semaphore(0); // semaforo do consumidor
	static Semaphore prod = new Semaphore(1); // semaforo do produtor

	void get(){

		try{
			con.acquire(); 
		}catch(InterruptedException e){
			System.out.println("Falha: "+ e);
		}
		System.out.println("Valor: "+value);
		prod.release();
	}

	void put(int n){
		try{
			prod.acquire();
		}catch(InterruptedException e){
			System.out.println("Falha: "+ e);
		}

		this.value = n;
		System.out.println("Valor inserido: "+n);
		con.release();
	}
}