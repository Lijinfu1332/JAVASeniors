package linkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 heroNode1=new HeroNode2(1,"王二","老王");
        HeroNode2 heroNode2=new HeroNode2(2,"张三","老张");
        HeroNode2 heroNode3=new HeroNode2(3,"李四","老李");
        HeroNode2 heroNode4=new HeroNode2(3,"李老头","隔壁老李");
        DoubleLinkedList doubleLinkedList=new DoubleLinkedList();
        doubleLinkedList.addByOrder(heroNode1);
        doubleLinkedList.addByOrder(heroNode3);
        doubleLinkedList.addByOrder(heroNode2);
        System.out.println("显示双链表");
        doubleLinkedList.list();
        System.out.println("修改");
        doubleLinkedList.update(heroNode4);
        doubleLinkedList.list();
        System.out.println("删除");
        doubleLinkedList.delete(3);
        doubleLinkedList.list();

    }
}
class DoubleLinkedList{
    //初始化头节点，不存放任何值
    HeroNode2 head=new HeroNode2(0,"","");
    //向链表中添加数据
    public void add(HeroNode2 heroNode){

        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while(true) {
            //找到链表的最后
            if(temp.next == null) {//
                break;
            }
            //如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = heroNode;
        heroNode.pre=temp;
    }
    //获取头节点
    public HeroNode2 getHead(){
        return head;
    }
    //向链表中有序添加数据
    public void addByOrder(HeroNode2 heroNode){
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode2 temp=head;
        boolean flag=false;//设置一个判断表标识变量
        while (true){
            if (temp.next==null){//当头节点的next域为空值时直接跳出
                break;
            }else if (temp.next.no>heroNode.no){
                break;
            }else if (temp.no==heroNode.no){//当数据存在时将标识变量改为真，表示已经存在
                flag=true;
                break;
            }
            temp=temp.next;
        }
        //判断标识变量来进行数据的添加
        if (flag){//表示要添加的数据已经存在
            System.out.printf("准备添加的英雄编号%d已经存在。。。",temp.next.no);
        }else{
            if (temp.next!=null){
                temp.next.pre=heroNode;
            }
            heroNode.next=temp.next;
            temp.next=heroNode;
            heroNode.pre=temp;

        }

    }

    /**
     * 修改链表中的数据
     */
    public void update(HeroNode2 newHeroNode){
        //判断是否空
        if(head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        //找到需要修改的节点, 根据no编号
        //定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false; //表示是否找到该节点
        while(true) {
            if (temp == null) {
                break; //已经遍历完链表
            }
            if(temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag 判断是否找到要修改的节点
        if(flag) {
            temp.name = newHeroNode.name;
            temp.nickName= newHeroNode.nickName;
        } else { //没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    /**
     * 删除队列中的数据
     */
    public void delete(int rankNo){

        if (head.next==null){
            System.out.println("链表中无数据");
            return;
        }
        HeroNode2 temp=head.next;
        boolean flag=false;
        while (true){
            if (temp==null){
                break;
            }else if (temp.no==rankNo){//如果查找到输入的编号则标识符变为真
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.pre.next=temp.next;
            if (temp.next!=null){
                temp.next.pre=temp.pre;
            }
        }else {
            System.out.printf("编号为%d的英雄不存在\n  ",rankNo);
        }
    }



    //显示链表中的数据
    public void list(){
        //先判断链表是否为空，如果为空则直接返回
        if (head.next==null) {
            System.out.println("链表为空");
            return ;
        }
        HeroNode2 temp = head.next;//遍历链表的下一个节点
        while (true) {
            //如果链表的下一个节点为空，则遍历完毕
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }
}
//英雄类
class HeroNode2{
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;
    public HeroNode2(int sNo,String sName,String SnickName){
        this.no=sNo;
        this.name=sName;
        this.nickName=SnickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
