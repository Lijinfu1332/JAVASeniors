package 生产者消费者;

 class Cleck {
     private int cleckCount=0;
     public synchronized void Producting() {
         if (cleckCount<20){
             notify();
             cleckCount++;
             System.out.println(Thread.currentThread().getName()+"开始生产第"+cleckCount+"个产品");
         }else {
             try {
                 wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }

     public synchronized void Cust() {
         if (cleckCount>0){
             notify();
             System.out.println(Thread.currentThread().getName()+"开始消费第"+cleckCount+"个产品");
             cleckCount--;
         }else {
             try {
                 wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }
 }
