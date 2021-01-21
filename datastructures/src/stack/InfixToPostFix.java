package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixToPostFix {
    public static void main(String[] args) {
        String expression="(30+(50-4))*5-6";
        List<String> list = StringToList(expression);//获取到中缀表达式的列表
        List<String> infixToPostFix = infixToPostFix(list);
        System.out.println(expression+"的逆波兰表达式是："+infixToPostFix);
        System.out.println("逆波兰数的运算值是"+Calculator(infixToPostFix));
    }
    public static  List<String> infixToPostFix(List<String > list) {
        Stack<String> operStack = new Stack<>();//用于存储运算符的栈
        List<String> numbeList = new ArrayList<>();//用于存储数字的列表数组
        for (String el : list) {//遍历字符数组
            if (el.matches("\\d+")) {//如果匹配出来为数字，则直接添加到数组
                numbeList.add(el);
            } else if (el.equals("(")) {//如果是“（”直接入栈
                operStack.push(el);
            } else if (el.equals(")")) {
                while (!operStack.peek().equals("(")) {//当运算符栈中的字符不为“（”运算符一直出栈并添加到数字数组中
                    numbeList.add(operStack.pop());
                }
                operStack.pop();//运算符")"出栈
            } else if (operStack.size()>0&&operStack.peek().equals("(")){
                operStack.push(el);
            }else {
                //当获取到的运算符的优先级小于或等于栈顶运算符的优先级进行运算符出栈
                while (operStack.size() != 0 && Operation.operation(el) <= Operation.operation(operStack.peek())){
                    numbeList.add(operStack.pop());//将运算符中的运算符一直出栈直到条件不满足时
                }
                operStack.push(el);
            }

        }
        //将栈中余下的运算符添加到数字数组中
        while (operStack.size()!=0){
            numbeList.add(operStack.pop());
        }
    return numbeList;

    }
    public static int Calculator(List<String> list){
        Stack<String> stack=new Stack<>();
        int result;
        for (String str:list) {
            if (str.matches("\\d+")){//匹配多位数
                stack.push(str);
            }else {
                int num1=Integer.parseInt(stack.pop());
                int num2=Integer.parseInt(stack.pop());
                if (str.equals("+")){
                    result=num1+num2;
                }else if (str.equals("-")){
                    result=num2-num1;
                }else if (str.equals("*")){
                    result=num1*num2;
                }else if (str.equals("/")){
                    result=num2/num1;
                }else {
                    throw new RuntimeException("输入的表达式有误");
                }
                stack.push(""+result);
            }
        }
        return Integer.parseInt(stack.pop());
    }
    public static List<String> StringToList(String string){//传入一个字符串，转成列表
        String str;//用于接收字符
        List<String> list=new ArrayList<>();//用于接收遍历出的字符
        int i=0;
        char c;
        do {
            if ((c=string.charAt(i))<48||(c=string.charAt(i))>57){//如果是运算符就直接保存到列表
                list.add(""+c);
                i++;
            }else {//如果是数字字符
                str="";
               while (i<string.length()&&(c=string.charAt(i))>=48&&(c=string.charAt(i))<=57){
                   str+=c;
                   i++;
               }
               list.add(str);
            }

        }while (i<string.length());
    return list;
    }
}
class Operation{//用于判断运算符的优先级
    public static int ADD=1;
    public static int SUB=1;
    public static int MUT=2;
    public static int DIV=2;
    public static int operation(String str){
        int res=0;
        switch (str){
            case "+":
                res=1;
                break;
            case "-":
                res=1;
                break;
            case "*":
                res=2;
                break;
            case "/":
                res=2;
                break;
            default:
                System.out.println("不存在的运算符");
                break;

        }
        return res;
    }
}
