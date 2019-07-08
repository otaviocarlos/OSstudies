class Consumer implements Runnable{
	Queue q;

	Consumer(Queue q){
		this.q = q;
		new Thread(this, "Consumer").start();
	}

	public void run(){
		for (int i=0; i<20; i++){
			q.get();
		}
	}
}