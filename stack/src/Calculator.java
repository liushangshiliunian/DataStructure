import org.omg.CORBA.StringHolder;

import java.util.logging.LoggingPermission;

public class Calculator {


    public static void main(String[] args) {
        String expression="30+2*6-2";
        ArrayStack2 sumsStack=new ArrayStack2(10);
        ArrayStack2 operStack=new ArrayStack2(10);
        int index=0;
        int num1=0;
        int num2=0;
        char temp=' ';
        String keepNum="";
        while(true) {
            char ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)){
                if (operStack.isEmpty()){
                    operStack.pushStack(ch);
                }
                if (operStack.priority(ch)>=operStack.priority((char)operStack.peek())){
                    operStack.pushStack(ch);
                }else if (operStack.priority(ch)<operStack.priority((char)operStack.peek())) {
                    num1 = sumsStack.popStack();
                    num2 = sumsStack.popStack();
                    temp=(char) operStack.popStack();
                    int cal = operStack.cal(num1, num2, temp);
                    sumsStack.pushStack(cal);
                    operStack.pushStack(ch);
                }
            }else {
//                sumsStack.pushStack(ch-48);

                keepNum += ch;
                if (index<expression.length()-1) {
                    if (operStack.isOper(expression.substring(index +1, index + 2).charAt(0))) {

                        sumsStack.pushStack(Integer.parseInt(keepNum));
                        keepNum = "";
                    }

                }else  if (index==expression.length()-1){
                    sumsStack.pushStack(Integer.parseInt(keepNum));
                }
            }
            index++;
            if (index>=expression.length()){
                break;
            }
        }
        while (sumsStack.getTop()!=0){
        num1 = sumsStack.popStack();
        num2 = sumsStack.popStack();
        temp=(char) operStack.popStack();
        int cal = operStack.cal(num1, num2, temp);
        sumsStack.pushStack(cal);
        }
        System.out.println("表达式结果为:"+sumsStack.popStack());
    }
}


class ArrayStack2{
    private int maxSize;
    private int top;
    private int[] stack;

    public boolean isOper(char oper){
        return oper=='*'||oper=='/'||oper=='+'||oper=='-';
    }

    public int priority(char oper){
        if (oper=='*'||oper=='/'){
            return 1;
        }else if (oper=='+'||oper=='-'){
        return 0;}
        else{return -1;}
    }

    public int peek(){
        return stack[top];
    }

    public int cal(int num1,int num2,char oper){
        int result=0;
        switch (oper){
            case '*':
                result=num1*num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            case '+':
                result = num2 + num1;
                break;
            case '-':
                result = num2 - num1;
                break;
        }
        return result;
    }


    public boolean isFull(){
        return top==maxSize-1;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public void pushStack(int i){
        if (isFull()){
            System.out.println("栈已满，请别重复操作");
            return;
        }
        top++;
        stack[top]=i;
    }

    public int  popStack(){
        if (isEmpty()){
            throw new RuntimeException("栈已空，请输入数据");
        }
        int value=stack[top];
        top--;
        return value;
    }

    public void listStack(){
        if (isEmpty()){
            System.out.println("栈已空，请输入数据");
            return;
        }
        for (int i=top;i>=0;i--){
            System.out.println(stack[i]);
        }
    }

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        top=-1;
        stack=new int[maxSize];
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int[] getStack() {
        return stack;
    }

    public void setStack(int[] stack) {
        this.stack = stack;
    }

}