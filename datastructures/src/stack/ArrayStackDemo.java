package stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack=new ArrayStack(20);
        boolean loop=true;
        String key="";
        Scanner scanner=new Scanner(System.in);
        while (loop){
            System.out.println("show:显示数据");
            System.out.println("pop:数据出栈");
            System.out.println("push:添加数据");
            System.out.println("exit:退出");
            key=scanner.next();
            switch (key){
                case "show":
                    try {
                        arrayStack.show();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "push":
                    System.out.println("请输入一个数据");
                    int value=scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int res=arrayStack.pop();
                        System.out.println("出栈的数据是："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }

        }
        System.out.println("程序退出~~~");

    }
}
class ArrayStack{
    private int maxsize;
    private int top=-1;//初始化栈顶为-1，栈内添加数据时栈顶+1
    private int stack[];
    //构造器
    public ArrayStack(int maxsize){
        this.maxsize=maxsize;
        stack=new int[maxsize];
    }
    //判断是否为空
    public boolean isEmpty(){
        return top==-1;
    }
    //判断栈是否为满
    public boolean ifFull(){
        return top==maxsize-1;
    }
    //添加数据向栈
    public void push(int value){
        if (ifFull()){
            System.out.println("栈满，不能添加数据");
        }
        top++;
        stack[top]=value;
    }
    //出栈
    public  int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈为空，无数据出栈");
        }
        int value=stack[top];
        top--;
        return value;
    }
    //显示栈中的数据
    public void show(){
        if (isEmpty()){
            throw new RuntimeException("栈内无数据");
        }
        for (int i=top;top>=0;top--){
            System.out.printf("stack[%d]=%d\n",top,stack[top]);
        }

    }
    //判断输入的是否是运算符
    public boolean isOper(int oper){
        return oper=='*'||oper=='+'||oper=='-'||oper=='/';
    }
    //判断优先级
    public int propetity(int oper){
        if (oper=='/'||oper=='*'){
            return 1;
        }else if (oper=='+'||oper=='-'){
            return 0;
        }else {
            return 0;
        }
    }
    //从栈中获取到数据进行运算
    public int getRes(int num1,int num2,int oper){
        int value=0;
        switch (oper){
            case '+':
                value=num1+num2;
            case '-':
                value=num2-num1;
            case '*':
                value=num1*num2;
            case '/':
                value=num2/num1;
        }
        return value;
    }
}