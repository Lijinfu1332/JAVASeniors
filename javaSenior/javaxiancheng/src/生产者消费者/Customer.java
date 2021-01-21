package 生产者消费者;

public class Customer implements Runnable{
    private Cleck cleck;

    public Customer(Cleck cleck) {
        this.cleck = cleck;
    }

    @Override
    public void run() {
        while (true){
            cleck.Cust();
        }

    }
}
