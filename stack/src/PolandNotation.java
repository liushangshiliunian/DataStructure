import netscape.security.UserTarget;

import java.awt.geom.Arc2D;
import java.awt.image.AreaAveragingScaleFilter;
import java.net.BindException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
            String s="1+((2+3)*4)-5";
        List list = toInfixExpressionList(s);
//        System.out.println(list);
        List list1 = parseSuffixExpreesionList(list);
        System.out.println(list1);
        int calculate = calculate(list1);
        System.out.println(calculate);

        //        String expression = "4 5 * 8 - 60 + 8 2 / +";
//        List<String> list = getList(expression);
//        System.out.println(list);
//        int result = calculate(list);
//        System.out.println("输出的结果是："+result);

    }

    public static List toInfixExpressionList(String s){
        ArrayList<String> list = new ArrayList();
        int i=0;
        String str="";
        while(i<s.length() ){
            if (s.charAt(i)<48||s.charAt(i)>57){
                list.add(s.charAt(i)+"");
                i++;
            }else{
                str="";
                while(i<s.length()&&s.charAt(i)>=48&&s.charAt(i)<=57){
                    str+=s.charAt(i);
                    i++;
                }
                list.add(str);
            }
        }
        return list;
    }

    public static List<String> parseSuffixExpreesionList(List<String> s) {
        Stack<String> strings = new Stack<>();
        ArrayList<String> list = new ArrayList<>();
       for (String str:s){
            if (str.matches("\\d+")) {
                list.add(str);
            }  else if (str.equals("(")) {
                    strings.push(str);
                } else if (str.equals(")")) {
                    while (!strings.peek().equals("(")) {
                        list.add(strings.pop());
                    }
                    strings.pop();
                } else {
                    while (strings.size() != 0&&Operation.getValue(strings.peek()) >= Operation.getValue(str)  ) {
                        list.add(strings.pop());
                    }
                   strings.push(str);
                }

        }
        while(strings.size() != 0){

            list.add(strings.pop());
        }
          return list;
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


class Operation{
        public int  ADD=1;
        public int  DEL=1;
        public int  MUL=2;
        public int  DIV=2;

        public static int   getValue(String operation){
            int resulet =0;
            switch (operation){
                case "+":
                     resulet=1;
                     break;
                case "-":
                    resulet=1;
                    break;
                case "*":
                    resulet=2;
                    break;
                case "/":
                    resulet=2;
                    break;
                default:
                    System.out.println("不存在该运算符" + operation);
                    break;
            }
            return resulet;
        }
}