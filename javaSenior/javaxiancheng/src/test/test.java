package test;


//1.创建一个方法继承Thread类
class MyThread extends Thread{
    //2.继承run方法
    public void run(){
      for (int i=0;i<10;i++){
          if (i%2==0){
              System.out.println(Thread.currentThread().getName());
              System.out.println(i);
          }
      }
    }
}
public class test {
    public static void main(String[] args) {
        //3.创建Thread的子类对象
        MyThread myThread=new MyThread();
        //4.通过调用start()对象
        myThread.start();
        MyThread myThread1=new MyThread();
        myThread1.start();
        System.out.println("hello");
    }
}