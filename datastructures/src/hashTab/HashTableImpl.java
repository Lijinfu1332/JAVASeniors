package hashTab;

import java.util.Scanner;

public class HashTableImpl {
    public static void main(String[] args) {
        HashTable hashTable=new HashTable(7);
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("add '添加员工'");
            System.out.println("list'显示员工'");
            System.out.println("find '查找员工'");
            System.out.println("delete '查找员工'");
            System.out.println("exit '退出'");
            String key=scanner.next();
            switch (key){
                case "add":
                    System.out.println("请输入员工id：");
                    int id=scanner.nextInt();
                    System.out.println("请输入员工姓名：");
                    String name=scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入员工编号");
                    id=scanner.nextInt();
                    hashTable.find(id);
                    break;
                case "delete":
                    System.out.println("请输入员工编号：");
                    id=scanner.nextInt();
                    hashTable.delete(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}
class HashTable{
    //创建生成hash表
    private HashLinkedListArray hashLinkedListArray[];
    private int size;
    //构造方法
    public HashTable( int size) {

        this.size = size;
        hashLinkedListArray = new HashLinkedListArray[size];
        //初始化链表
        for (int i = 0; i < size; i++) {
            hashLinkedListArray[i]=new HashLinkedListArray();
        }
    }
    //添加方法
    public void add(Emp emp){
        int hashTabNo=hashFun(emp.id);
        hashLinkedListArray[hashTabNo].add(emp);
    }
    //显示雇员信息
    public void list(){
        for (int i = 0; i < size; i++) {
            hashLinkedListArray[i].list(i);
        }
    }
    //查找
    public void find(int id){
        int empNo=hashFun(id);//判断要去那条链表中查找
        Emp emp = hashLinkedListArray[empNo].find(id);
        if (emp!=null){
            System.out.println("找到员工Id为："+id);
        }else {
            System.out.println("没有找到员工");
        }

    }
    //删除
    public void delete(int id){
        int empNo=hashFun(id);
        hashLinkedListArray[empNo].delete(id);
    }
    //散列算法
    public int hashFun(int id){
        return id/size;
    }

}
class Emp{
    int id;
    String name;
    Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
class HashLinkedListArray{
    //创建链表的头节点
    Emp head;
    //添加方法
    public void add(Emp emp){
        //如果链表为空
        if (head==null){
            head=emp;
        }
        //如果链表不为空
        Emp temp=head;
        while (true){
            //当遍历到最后一个节点时退出
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=emp;
    }
    //遍历链表的雇员信息
    public void list(int no) {
        if(head == null) { //说明链表为空
            System.out.println("第 "+(no+1)+" 链表为空");
            return;
        }
        System.out.print("第 "+(no+1)+" 链表的信息为");
        Emp curEmp = head; //辅助指针
        while(true) {
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            if(curEmp.next == null) {//说明curEmp已经是最后结点
                break;
            }
            curEmp = curEmp.next; //后移，遍历
        }
        System.out.println();
    }
    //查找员工
    public Emp find(int id){
        if (head==null){
            return null;
        }
       Emp curEmp=head;
        while (true){
            if (curEmp.id==id){//找到了
                break;
            }else if (curEmp.next==null){//没有找到
                curEmp=null;
                break;
            }
                curEmp=curEmp.next;

        }
        return curEmp;
    }
    //删除员工
    public void delete(int id){
        if (head==null){
            System.out.println("该员工不存在");
            return;
        }
        if (head.id==id&&head.next==null){//当头节点就是要删除的元素时并且头节点的下一个节点不为空
                head=null;
        }
        Emp curEmp=head;
        while (true){
            if (curEmp.next==null){
                System.out.println("该员工不存在");
                break;
            }
            if (curEmp.next.id==id){//找到了
                System.out.println("删除员工id为："+curEmp.next.id);
                    curEmp.next=curEmp.next.next;
                    break;
                }
                curEmp=curEmp.next;
            }

    }
}
