package linkedList;

public class JosePhu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList=new CircleSingleLinkedList();
        circleSingleLinkedList.add(100);
        circleSingleLinkedList.show();
        System.out.println("小孩出圈");
        circleSingleLinkedList.popJosephu(5,5,100);

    }
}

/**
 * 创建一个单向环形链表
 */
class CircleSingleLinkedList{
    private Boy first=null;
    public void add(int nums){
        if (nums<1){
            System.out.println("你输入的值不正确");
            return;
        }
        Boy temp=null;//辅助指针用于创建环形链表
        for (int i = 1; i <=nums ; i++) {
            Boy boy=new Boy(i);
            if (i==1){
                first=boy;
                first.setNext(first);//如果为第一个元素时让他的next指向它本身
                temp=first;
            }else {
                temp.setNext(boy);
                boy.setNext(first);//
               temp = boy;
            }
        }

    }
    public void show(){
        if (first==null){
            System.out.println("该环形单链表中无任何元素~~~");
            return;
        }
        Boy temp=first;
        while (true){
            System.out.println("孩子编号为:"+temp.getNo());
            if (temp.getNext()==first){//如果该节点的数据next域为头节点，则终止遍历
                break;
            }
            temp=temp.getNext();
        }
    }
    /**
     * 约瑟夫问题出循环链表
     */
    public void popJosephu(int startNo,int num,int nums){
        if (startNo<=0||num<=1||nums<1){
            System.out.println("输入的数据有误");
            return;
        }
        Boy helper=first;
        while (true){//先找到辅助节点的位置
            if (helper.getNext()==first){//如果辅助变量的next节点指向头节点则退出
                break;
            }
            helper=helper.getNext();
        }
        //移动前先让first和helper移动k-1次
        for (int i=0;i<startNo-1;i++){
            first=first.getNext();
            helper=helper.getNext();
        }
        //
        while (true){
            if (first==helper){//说明圈中只有一个节点
                break;
            }
            for (int i = 0; i < num-1; i++) {
                first=first.getNext();
                helper=helper.getNext();

            }
            //打印要出圈的小孩
            System.out.println("要出圈的小孩为"+first.getNo());
            //进行出圈操作
            first=first.getNext();//将first指针后移一位
            helper.setNext(first);//辅助指针指向后移后的指针
        }
        System.out.println("最后出圈的节点为"+first.getNo());


    }
}

class Boy {
    private int no;
    private Boy next;
    public Boy(int no){
        this.no=no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
