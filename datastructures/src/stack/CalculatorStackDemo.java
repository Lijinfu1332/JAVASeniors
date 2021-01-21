package stack;

public class CalculatorStackDemo {
    public static void main(String[] args) {
            CalculatorStack numberStack=new CalculatorStack(20);
            CalculatorStack  operStack=new CalculatorStack(20);
            String expression="5+20*1-5+400";
            int index=0;
            int num1=0;//获取第一个出栈的数
            int num2=0;//获取第二个出栈的数
            int oper=0;//用于保存运算符
            int res=0;
            char ch=' ';//保存每次扫描到的字符
            String keepNum="";//用于拼接多个字符
            while (true){//进行入栈操作
                ch=expression.substring(index,index+1).charAt(0);
                if (operStack.isOper(ch)){//判断是否是运算符
                    if (operStack.isEmpty()){//判断运算符栈是否为空，为空直接入栈
                        operStack.push(ch);
                    }else {//栈内不为空则分情况进行运算
                        if (operStack.propetity(ch)<=operStack.propetity(operStack.peek())){//判断运算符的优先级大于运算符栈顶元素
                            oper=operStack.pop();//取出栈顶运算符
                            num1=numberStack.pop();
                            num2=numberStack.pop();
                            res=numberStack.getRes(num1,num2,oper);//运算两个数字的值后再入栈
                            numberStack.push(res);
                            operStack.push(ch);
                        }else {
                            operStack.push(ch);
                        }
                    }
                }else {//是数字的话直接入栈
                    keepNum+=ch;
                    if (index==expression.length()-1){//判断是否是最后一个字符
                        numberStack.push(Integer.parseInt(keepNum));
                    }else {//判断是否是运算符
                        //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                        //注意是看后一位，不是index++
                        if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))) {
                            //如果后一位是运算符，则入栈 keepNum = "1" 或者 "123"
                            numberStack.push(Integer.parseInt(keepNum));
                            //重要的!!!!!!, keepNum清空
                            keepNum = "";
                        }
                    }
                }
                //让index + 1, 并判断是否扫描到expression最后.
                index++;
                if (index >= expression.length()) {
                    break;
                }
            }
            //获取到最后的结果
        while (true){
            if (operStack.isEmpty()){
                break;
            }
            num1=numberStack.pop();
            num2=numberStack.pop();
            oper=operStack.pop();
            res=numberStack.getRes(num1,num2,oper);
            numberStack.push(res);
        }
        res=numberStack.pop();
        System.out.println(res);

    }
}
class CalculatorStack{
    private int maxsize;
    private int top=-1;//初始化栈顶为-1，栈内添加数据时栈顶+1
    private int stack[];
    //构造器
    public CalculatorStack(int maxsize){
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
    //查看栈顶元素
    public int peek(){
        return stack[top];
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
                break;
            case '-':
                value=num2-num1;
                break;
            case '*':
                value=num1*num2;
                break;
            case '/':
                value=num2/num1;
                break;
        }
        return value;
    }
}
