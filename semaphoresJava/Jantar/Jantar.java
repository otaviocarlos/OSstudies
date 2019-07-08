public class Jantar {
    public static void main(String[] args) {
        Mesa m = new Mesa();
        Thread f0 = new Filosofos(0, m);
        Thread f1 = new Filosofos(1, m);
        Thread f2 = new Filosofos(2, m);
        Thread f3 = new Filosofos(3, m);
        Thread f4 = new Filosofos(4, m);
        f0.start();
        f1.start();
        f2.start();
        f3.start();
        f4.start();
    }
}


