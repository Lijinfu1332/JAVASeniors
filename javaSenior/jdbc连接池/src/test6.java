public class test6 {
    public static void main(String[] args) {
        (new MyThread()).start();
        (new MyThread()).start();
    }
}
class MyThread extends Thread{
    static int data[]=new int[500];
    static int size=0;

    @Override
    public synchronized   void run() {
        while (size<500){
            data[size++]=size;

    }}
}
