package test;

class Runnables implements Runnable {
    //实现Runnable中的run方法
    private int ticket=100;
   // Object obj=new Object();
    @Override
    public void run() {
        /*for (int i=100;i>0;i--){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }*/
        //解决线程安全问题：
        //              同步代码块上锁时必须是共用同一把锁
        while (true){
            //synchronized(obj){
            //
            synchronized(this){
            if (ticket>0){
                System.out.println(Thread.currentThread().getName()+"卖票，票号为："+ticket);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket--;
            }else {
                break;
            }
        }}
}
public static class test3 {
    public static void main(String[] args) {
        //创建实现类的对象
        Runnables thread = new Runnables();
        //将此对象作为参数传到Threa类的构造器中，创建Thread对象
        Thread t1 = new Thread(thread);
        Thread t2 = new Thread(thread);
        Thread t3 = new Thread(thread);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();

    }}}