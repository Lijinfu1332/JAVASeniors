package 线程通信;

public class ThreadAdd {
    public static void main(String[] args) {
        test6 t=new test6();
        Thread c1=new Thread(t);
        Thread c2=new Thread(t);
        c1.start();
        c2.start();

    }
}
class test6 implements Runnable{
    private int number=100;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                this.notify();
                if (number > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    number--;
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    break;
                }
            }
        }
    }
}