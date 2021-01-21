package 账户存钱;

import java.util.concurrent.locks.ReentrantLock;

class Account {
  private double money;
  //1.创建锁对象
  private ReentrantLock lock=new ReentrantLock();

  public Account(double money) {
   this.money = money;
  }
  //存钱
  /*
  //使用synchronized
  public synchronized void  saveMoney(double tmp){
   if(tmp>0){
    try {
     Thread.sleep(100);
    } catch (InterruptedException e) {
     e.printStackTrace();
    }
    money+=tmp;
    System.out.println("存钱成功，余额为："+money);
   }
  }*/
  //使用
  public  void  saveMoney(double tmp){
   try {
    //2.上锁
    lock.lock();
    if(tmp>0){
     try {
      Thread.sleep(100);
     } catch (InterruptedException e) {
      e.printStackTrace();
     }
     money+=tmp;
     System.out.println("存钱成功，余额为："+money);
    }
   }finally {
    //3.释放锁
    lock.unlock();
   }

  }
 }
