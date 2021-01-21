package QueueImpl;

/**
 * 循环队列的使用
 */
public class CircleQueue {
    private int maxSize;
    private  int front;
    private  int rear;
    private  int[] arr;
    //创建队列的构造方法
    public CircleQueue(int arrSize){
        maxSize=arrSize;
        arr=new int[maxSize];
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //判断队列是否为满
    public  boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    //向环形队列添加数据
    public void addQueue(int n){
        if (isFull()){
            throw new RuntimeException("队列满，无法添加数据");
        }
        arr[rear]=n;
        rear=(rear+1)%maxSize;
    }
    //获取队列中的数据
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有元素可以出栈");
        }
        int value;
        value=arr[front];
        front=(front+1)%maxSize;
        return value;
    }
    //展示队列中的所有元素
    public void show(){
        if (isEmpty()){
            throw new RuntimeException("队列中没有元素");
        }
        System.out.println("队列中有以下元素");
        for (int i=front%maxSize;i<front+size();i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i]);
        }
    }
    //
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
    //显示队列头元素
    public int headQueue(){
        if (isEmpty()){
            throw new  RuntimeException("队列中无元素");
        }
        return arr[front];
    }
}
