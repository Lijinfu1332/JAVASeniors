package test;

 class test1 extends Thread{
   private static int ticket=100;
    private  static Object obj=new Object();
    @Override
    public void run() {
        while (true){
            synchronized (obj){
        if(ticket>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName()+"卖出票"+ticket);
            ticket--;
        }else {
            System.exit(0);
        }
    }}}
}
public class Window{
    public static void main(String[] args) {
        test1 t1=new test1();
        test1 t2=new test1();
        test1 t3=new test1();
        t1.setName("Thread1");
        t2.setName("Thread2");
        t3.setName("Thread3");

        t1.start();
        t2.start();
        t3.start();
    }
}