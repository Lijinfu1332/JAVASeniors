package 生产者消费者;

public class Product {
    public static void main(String[] args) {
        //创建生产者和消费者继承Runnable接口的实现对象
        Cleck c=new Cleck();
        Customer customer=new Customer(c);
        Producer producer=new Producer(c);
        Thread c1=new Thread(customer);
        Thread p1=new Thread(producer);
        c1.setName("消费者");
        p1.setName("生产者");
        c1.start();
        p1.start();
    }
}
