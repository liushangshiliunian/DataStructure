package com.atguigu;

import java.rmi.ConnectIOException;

public class Josepfu {
    public static void main(String[] args) {
        CircleLinked dbl= new CircleLinked();
        dbl.addBoy(125);
        dbl.showBoy();

        dbl.countBoy(1,2,5);
    }

}

class CircleLinked{
        private Boy first=null;

        public void  addBoy(int nums ){
            if (nums<1){
                System.out.println("nums的值不正确");
                return;
            }
            Boy curBoy=null;
            for (int i=1;i<=nums;i++){
                Boy boy=new Boy(i);
                if (i==1){
                    first=boy;
                    first.setNext(first);
                    curBoy=first;
                }else {
                    curBoy.setNext(boy);
                    boy.setNext(first);
                    curBoy=boy;
                }
            }
        }
    public void showBoy (){
            if (first==null){
                System.out.println("没有任何小孩");
                return;
            }
            Boy curBoy=first;
            while (true){
                System.out.printf("小孩编号%d\n",curBoy.getNo());
                if (curBoy.getNext()==first){
                    break;
                }
              curBoy=curBoy.getNext();
            }
    }
    public void countBoy(int startNo,int countNum,int nums){
            this.addBoy(nums);
            if (first==null||startNo<1||startNo>nums){
                System.out.println("参数有误，请重新输入");
                return;
            }
            Boy helper=first;
            while (true){
                if (helper.getNext()==first){
                    break;
                }
                helper=helper.getNext();
            }
            for (int i=0;i<startNo-1;i++){
                first=first.getNext();
                helper=helper.getNext();
            }
            while (true){
                if (first==helper){
                    break;
                }
                for (int i=0;i<countNum-1;i++) {
                    first = first.getNext();
                    helper = helper.getNext();
                }
                System.out.printf("小孩出圈编号%d\n",first.getNo());
                first=first.getNext();
                helper.setNext(first);
            }
        System.out.printf("最后一位小孩编号%d\n",first.getNo());
    }
}

class Boy{
    private int no;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    private  Boy next;

    public Boy(int no ){
        this.no =no ;
    }
}