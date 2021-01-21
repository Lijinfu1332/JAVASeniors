package 生产者消费者;

public class Producer implements Runnable{
    private Cleck cleck;

    public Producer(Cleck cleck) {
        this.cleck = cleck;
    }


    @Override
    public void run() {
        while (true){
            cleck.Producting();
        }
    }
}
