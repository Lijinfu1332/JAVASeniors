public class test8 {
    public static void main(String[] args) {
        C c1=new C(1);
        C c2=new C(2);
        Thread t1=new Thread(()->{c1.work(c2);});
        Thread t2=new Thread(()->{c2.work(c1);});
        t1.start();
        t2.start();
    }
}
class C{
    private int id;
    public C(int id){this.id=id;}
    synchronized void work(C other){
        try {
            Thread.sleep(10);
        }catch (InterruptedException e){}
        synchronized (other){
            System.out.println("Threading"+id+"is running.");
        }
    }
}
