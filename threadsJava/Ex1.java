public class Ex1 extends Thread
{
	private int num;

	public Ex1(int num){
		this.num = num;
	}

	public boolean isPrime(){
		int cont = 0;
		for(int i = 1; i < num+1; i++){
			if(num%i == 0){
				cont++;
			}
		}
		if(cont > 2)
			return false;

		return true;
	}

	@Override
	public void run(){
		if(isPrime()){
			System.out.println(Thread.currentThread().getName()+" says: "+num + " is prime");
		}
	}
}