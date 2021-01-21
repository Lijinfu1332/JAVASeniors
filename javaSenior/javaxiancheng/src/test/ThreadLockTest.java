package test;
/*
    死锁的演示
 */
public class ThreadLockTest {
    public static void main(String[] args) {
        StringBuffer s1=new StringBuffer();
        StringBuffer s2=new StringBuffer();
        //通过创建对象实现该方法
        new Thread(){
            @Override
            public void run() {
                synchronized(s1){
                s1.append("a");
                s2.append("1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (s2){
                    s2.append("2")   ;
                    s1.append("b");
                }

                System.out.println(s1);
                System.out.println(s2);
            }
        }.start();
        //通过实现Runnable接口
        new Thread(new Runnables(){
            @Override
            public void run() {
                synchronized (s2){
                    s2.append("2");
                    s1.append("d");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (s1){
                    s1.append("c");
                    s2.append("5");
                }
                System.out.println(s1);
                System.out.println(s2);
            }
        }).start();
    }
}
