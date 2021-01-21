package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolishNotation {
    public static void main(String[] args) {
        //计算：4*5+60-100/2=>:4 5 * 60 + 100 2 / -
        //计算：4*5+6-10=>:4 5 * 6 + 10 -
        //创建一个逆波兰表达式
        String polishExpression="4 5 * 6 + 10 -";
        List<String> list = list(polishExpression);
        int calculator = Calculator(list);
        System.out.println(calculator);
    }
    public  static  List<String>  list(String expression){
        String[] split = expression.split(" ");
        List<String> arrayList=new ArrayList<>();
        for (String el: split
             ) {
            arrayList.add(el);
        }
        return arrayList;
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
}
