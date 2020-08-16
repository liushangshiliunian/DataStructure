package com.atguigu;

import java.util.List;
import java.util.Scanner;

public class ArrayQueueDemo {
    private int maxSize;
    private int front;
    private int rear;
    private int arr[];

    public static void main(String[] args) {
        ArrayQueueDemo aqd = new ArrayQueueDemo(3);
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        while(loop){
            System.out.println("a:显示对列");
            System.out.println("b:退出程序");
            System.out.println("c:添加数据");
            System.out.println("d:从对列中取数据");
            System.out.println("e:查看对列列头数据");
            char c = scanner.next().charAt(0);
            switch (c){
                case 'a':
                    aqd.showQueue();
                    break;
                case 'b':
                    loop=false;
                    break;
                case 'c':
                    int value = scanner.nextInt();
                    aqd.addQueue(value);
                    break;
                case 'd':
                    try {
                        int queue = aqd.getQueue();
                        System.out.printf("%d\n",queue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    try {
                        int i = aqd.headQueue();
                        System.out.printf("%d\n",i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public ArrayQueueDemo(int arrMaxsize){
        front =-1;
        rear=-1 ;
        maxSize=arrMaxsize;
        arr =new int [arrMaxsize];
    }
    public boolean isfull(){
       return  rear==maxSize-1;
    }
    public boolean isEmpty(){
       return front==rear;
    }
    public void addQueue(int j){
        if (this.isfull()){
            System.out.println("不还意思队列已满！");
            return;
        }
        rear++;
        arr[rear]=j;
    }
    public int getQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列为空,不能取数据");
        }
        front++;
        return arr[front];
    }
    public void showQueue(){
        if (isEmpty()){
            System.out.println("没有数据");
            return;
        }
        for (int i:arr){
            System.out.printf("%d\n",i);
        }
    }
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("没有数据，队列为空");
        }
        return  arr[front+1];
    }
}
