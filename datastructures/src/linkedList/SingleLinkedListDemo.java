package linkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1=new HeroNode(1,"王二","老王");
        HeroNode heroNode2=new HeroNode(2,"张三","老张");
        HeroNode heroNode3=new HeroNode(3,"李四","老李");
        HeroNode heroNode4=new HeroNode(5,"李老头","隔壁老李");
        SingleLinkedList linkedList=new SingleLinkedList();
        linkedList.add(heroNode1);
        linkedList.add(heroNode2);
        linkedList.add(heroNode3);
        linkedList.add(heroNode4);
        //linkedList.addByOrder(heroNode1);
       // linkedList.addByOrder(heroNode2);
       // linkedList.addByOrder(heroNode3);
        //linkedList.list();
        System.out.println("修改前。。。");
        linkedList.update(heroNode4);
        System.out.println("修改后。。。");
        linkedList.list();

        //linkedList.delete(3);
        //System.out.println("删除后。。。");
        //linkedList.list();

        //节点的有效个数测试
        System.out.println("有效节点个数为："+count(linkedList.getHead()));
        //遍历倒数的元素
        System.out.println("倒数第2个元素为"+lastRankHeroNode(linkedList.getHead(),2));
        //单链表反转
        System.out.println("逆序前~~~");
        linkedList.list();
        //System.out.println("反转后~~~");
       // reverse(linkedList.getHead());
       // linkedList.list();
        //逆序打印单链表
        printReverse(linkedList.getHead());
        /**
         * 问题：将两个单链表合并为一个并有序加入
         */


    }
    /**
     * 百度面试题
     * 逆序打印单链表
     */
    public static  void printReverse(HeroNode head){
        if (head.next==null){
            return;
        }
        Stack<HeroNode> stack=new Stack<HeroNode>();
        HeroNode res=head.next;
        while (res!=null){//如果辅助值不为空，则将链表中的数据压入栈中
            stack.push(res);
            res=res.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }

    }
    /**
     * 腾讯面试题：单链表的反转
     *
     */
    public static void reverse(HeroNode head){
        if (head.next==null||head.next.next==null){
            return;
        }
        HeroNode res=head.next;//定义一个辅助变量
        HeroNode next=null;
        HeroNode reverseHead=new HeroNode(0,"","");
        while (res!=null){//辅助变量不为null时执行反转操作
            next=res.next;//先让辅助变量的next域值给next
            res.next=reverseHead.next;//反转单链表的next域赋值给辅助变量的next
            reverseHead.next=res;//辅助变量数值不为空时将反转链表的头节点的next域指向res
            res=next;//res指向next
        }
        head.next=reverseHead.next;//遍历完成后将head的next域指向reverse的next域

    }
    /**
     * 新浪面试题
     * 返回倒数第几个元素：不包含头节点
     */
    public static HeroNode lastRankHeroNode(HeroNode head,int index){//传入两个参数，一个是heroNode,另外一个是索引
        if (head.next==null){
            return null;
        }
        int size=count(head);
        HeroNode cur=head.next;
        if (index<=0||index>size){//输入的索引值大于size或者小于0则不存在
            return null;
        }
        for (int i = 0; i < size-index; i++) {//利用辅助变量来遍历倒数的元素
            cur=cur.next;
        }
        return cur;
    }
    /**
     * 新浪面试题
     * 统计单链表的节点有效个数：不包含头节点
     */
    public static int count(HeroNode head){
        if (head.next==null){//如果单链表的头节点的下一节点为空，则节点数为0
            return 0;
        }
        int length=0;//统计节点个数
        HeroNode current=head.next;
        while (current!=null){
            length++;
            current=current.next;
        }
        return length;
    }
}
/**
 * 单链表实现
 */
class SingleLinkedList{
    //初始化头节点，不存放任何值
     HeroNode head=new HeroNode(0,"","");
    //向链表中添加数据
    public void add(HeroNode heroNode){

        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
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
    }
    //获取头节点
    public HeroNode getHead(){
        return head;
    }
    //向链表中有序添加数据
    public void addByOrder(HeroNode heroNode){
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp=head;
        boolean flag=false;//设置一个判断表标识变量
        while (true){
        if (temp.next==null){//当头节点的next域为空值时直接跳出
            break;
        }else if (temp.next.no>heroNode.no){
            break;
        }else if (temp.next.no==heroNode.no){//当数据存在时将标识变量改为真，表示已经存在
            flag=true;
            break;
        }
        temp=temp.next;
        }
        //判断标识变量来进行数据的添加
        if (flag){//表示要添加的数据已经存在
            System.out.printf("准备添加的英雄编号%d已经存在。。。",temp.next.no);
        }else{
            temp.next=heroNode.next;
            temp.next=heroNode;
        }

    }

    /**
     * 修改链表中的数据
     */
    public void update(HeroNode newHeroNode){
        //判断是否空
        if(head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        //找到需要修改的节点, 根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
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
        HeroNode temp=head.next;
        boolean flag=false;
        while (true){
            if (temp.next==null){
                break;
            }else if (temp.next.no==rankNo){//如果查找到输入的编号则标识符变为真
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.next=temp.next.next;
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
            HeroNode temp = head.next;//遍历链表的下一个节点
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

/**
 * 实现水浒英雄单链表类
 */
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;
    public HeroNode(int sNo,String sName,String SnickName){
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