package test;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadLock {
    public static void main(String[] args) {
        test4 t=new test4();
        Thread t1=new Thread(t);
        Thread t2=new Thread(t);
        Thread t3=new Thread(t);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
class test4 implements Runnable{
    private static int ticket=100;
    //1.创建该锁的对象
    private  static ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
      while (true){
          try {
              //2.上锁
              lock.lock();
              if(ticket>0){
                  System.out.println(Thread.currentThread().getName()+"售票，票号为："+ticket);
                  try {
                      Thread.sleep(100);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  ticket--;
              }
          }finally {
              //3.释放锁
                    lock.unlock();
          }

      }
    }
}