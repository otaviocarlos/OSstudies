public class Filosofos extends Thread {
    private int cadeira;
    private Mesa m;
    private final int delay = 1000;
    public Filosofos(int cadeira, Mesa m) {
        this.cadeira = cadeira;
        this.m = m;
    }
    public void run() {
        while (true) {
            pensar();
            m.pegarGarfo(cadeira);
            comer();
            m.largarGarfos(cadeira);
            m.mostraEstados();
        }
    }
    public void pensar() {
        try {
            Thread.sleep((int) (delay * Math.random()));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void comer() {
        try {
            Thread.sleep((int) (delay * Math.random()));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
