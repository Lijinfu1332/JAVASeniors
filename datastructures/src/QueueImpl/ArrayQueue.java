package QueueImpl;

public class ArrayQueue {
    /**
     * 队列的使用
     * 遵循原则：先进先出
     */
    int maxSize;
    int front;
    int rear;
    int[] arr;
    //队列的构造器
    public ArrayQueue(int arrMaxSize){
        maxSize=arrMaxSize;
        front=-1;
        rear=-1;
        arr=new int[arrMaxSize];
    }
    //判断队列是否为空
    public  boolean isEmpty(){
        return rear==front;
    }
    //判断队列是否为满
    public boolean isFull(){
        return front==maxSize-1 ;
    }
    //向队列中添加数据
    public void addValue(int value){
        if (isFull()){
            throw new RuntimeException("队列已经满了");
        }
        rear ++;
        arr[rear]=value;
    }
    //获取到队列中的数据
    public int getValue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，请先存入数据");
        }
        front ++;
        return arr[front];
    }
    public  void show(){
        if (isEmpty()){
            System.out.println("此队列为空，没有数据");
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //显示队列的头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }

}
