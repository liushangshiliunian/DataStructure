import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        boolean loop =true;
        Scanner scanner = new Scanner(System.in);

        while(loop){
            System.out.println("show：显示栈数据");
            System.out.println("push：添加数据");
            System.out.println("pop： 取出数据");
            System.out.println("exit：退出程序");
            System.out.println("输出你的选择");
            String key = scanner.next();
            switch (key){
                case "show":
                    stack.listStack();
                    break;
                case "push":
                    System.out.println("请输入数据");
                    int i = scanner.nextInt();
                    stack.pushStack(i);
                    break;
                case "pop":
                    try {
                        int i1 = stack.popStack();
                        System.out.println(i1);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    loop=false;
                    break;
            }
        }
        System.out.println("你已退出程序");
    }
}



class ArrayStack{
    private int maxSize;
    private int top;
    private int[] stack;

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

    public ArrayStack(int maxSize) {
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