
import java.util.concurrent.Semaphore;

public class Mesa {

    private final int n = 5;
    private final int faminto = 1;
    private final int pensando = 0;
    private final int comendo = 2;
    private int estado[];
    private Semaphore s[] = new Semaphore[] { new Semaphore(0),
            new Semaphore(0), new Semaphore(0), new Semaphore(0),
            new Semaphore(0) };
    private Semaphore mutex;
    private int left, right;

    public Mesa() {
        estado = new int[5];
        mutex = new Semaphore(1);
    }

    public void pegarGarfo(int i) {
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        estado[i] = faminto;
        testar(i);
        mutex.release();

        try {
            s[i].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testar(int i) {
       int ESQUERDA = (i+n-1)%n;
       int DIREITA = (i+1)%n;
       if (estado[i] == faminto && estado[ESQUERDA] != comendo
                && estado[DIREITA] != comendo) {
            estado[i] = comendo;
            s[i].release();
        }
    }

    public void largarGarfos(int i) {
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        estado[i] = pensando;
        testar(left(i));
        testar(right(i));
        mutex.release();

    }

    public int left(int i) {
        left = (i + n - 1) % n;
        return left;
    }

    public int right(int i) {
        right = (i + n) % n;
        return right;
    }

   public int getEstado(int i){
        return estado[i];
    }

    public void mostraEstados()
    {
          for(int n=0;n< this.n;n++)
    {
            System.out.printf("F%d ",(n+1));
            switch(estado[n])
            {
            case pensando: {
                System.out.printf("PENSANDO ");
                break;
            }
            case faminto:
            {
                System.out.printf("FAMINTO ");
                break;
            }
            case comendo:
            {
                System.out.printf("COMENDO ");
                break;
            }
            default:
            {
                break;
            }
            }
        }
        System.out.printf("\n");
    }
}