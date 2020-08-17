import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        String expression = "4 5 * 8 - 60 + 8 2 / +";
        List<String> list = getList(expression);
//        System.out.println(list);
        int result = calculate(list);
        System.out.println("输出的结果是："+result);

    }

    public static int calculate(List<String> list){
        Stack<Integer> numStack = new Stack();
            for (String str :list){
                if (str.matches("\\d+")){
                    numStack.push(Integer.parseInt(str));
                }else {
                    int num1 = numStack.pop();
                    int num2 = numStack.pop();
                    int result=0;
                    if (str.equals("+")) {
                        result = num1 + num2;
                    } else if (str.equals("-")) {
                        result = num2 - num1;
                    } else if (str.equals("*")) {
                        result = num1 * num2;
                    } else if (str.equals("/")) {
                        result = num2 / num1;
                    }else {
                        throw new RuntimeException("运算符有误");
                    }
                    numStack.push(result);
                }
            }
            return  numStack.pop();
        }


    public static List getList(String s){
        String[] s1 = s.split(" ");
        List <String> list=new ArrayList<String>();
        for (String str:s1){
            list.add(str);
        }
        return list;
    }
}
