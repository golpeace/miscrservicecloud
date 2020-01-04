public class TheandTest implements Runnable {
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("TheandTest : "+name);
    }
}

