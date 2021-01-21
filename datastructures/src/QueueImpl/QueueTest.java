package QueueImpl;

import java.util.Scanner;

public class QueueTest {
    public static void main(String[] args) {
        CircleQueue queue=new CircleQueue(5);
        boolean loop=true;
        char key=' ';
        Scanner src=new Scanner(System.in);
        while (loop){
            System.out.println("'a':添加数据");
            System.out.println("'q'Queue:初始化队列");
            System.out.println("'g'getValue:获取队列中的值");
            System.out.println("'s'show:展示队列");
            System.out.println("'h'headQueue:初始化队列");
            System.out.println("'e':获取队列头部数据");
            key=src.next().charAt(0);
            switch (key){
                case 'a':
                    System.out.println("请输入一个数");
                    try {
                        int value=src.nextInt();
                        queue.addQueue(value);
                    }catch (Exception e){
                        System.out.println( e.getMessage());
                    }

                    break;
                case 'g':
                    try {
                        int v=queue.getQueue();
                        System.out.println("获取到的值为："+v);
                    }catch (Exception e){
                        System.out.println( e.getMessage());
                    }

                    break;
                case 's':
                    try {
                        queue.show();
                    }catch (Exception e){
                        System.out.println( e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        queue.headQueue();
                    }catch (Exception e){
                        System.out.println( e.getMessage());
                    }
                    break;
                case 'e':
                    System.out.println("程序退出！！！");
                    System.exit(0);
                    break;

            }

        }


    }
}
