package com.atguigu;

import javafx.scene.shape.Circle;

import java.util.Scanner;

public class CircleArrayQueue {
    private int[] arr;
    private  int front=0;
    private  int rear=0;
    private  int maxsize;

    public static void main(String[] args) {
        CircleArrayQueue caq = new CircleArrayQueue(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
       while(loop){
           System.out.println("a:显示对列");
           System.out.println("b:添加数据");
           System.out.println("c:从对列中取数据");
           System.out.println("d:查看对列列头数据");
           System.out.println("e:退出程序");
           char c = scanner.next().charAt(0);
           switch (c){
               case 'a':
                   caq.showQueue();
                   break;
               case 'b':
                   int i = scanner.nextInt();
                   caq.addQueue(i);
                   break;
               case 'c':
                   try {
                       System.out.println(caq.getQueue());
                   } catch (Exception e) {
                       System.out.println(e.getMessage());
                   }
                   break;
               case 'd':
                   try {
                       int res = caq.headQueue();
                       System.out.printf("队列头的数据是%d\n", res);
                   } catch (Exception e) {
                       System.out.println(e.getMessage());
                   }
                   break;
               case 'e':
                   loop=false;break;
               default:
                   break;

           }
       }
    }


    public CircleArrayQueue(int arryMaxsize){
        maxsize=arryMaxsize;
        arr=new int [maxsize];
    }
    public boolean isFull(){
        return  (rear+1)%maxsize==front;
    }
    public boolean isEmpty(){
        return rear==front;
    }
    public void showQueue(){
        if (isEmpty()){
            System.out.println("没有数据，亲输入");
            return;
        }
        int emp = (rear+maxsize-front)%maxsize;

        for (int i=front;i< front+emp;i++){
            System.out.printf("arr[%d]=%d\n", i % maxsize, arr[i % maxsize]);
        }
    }
    public void addQueue(int value){
        if (isFull()){
            System.out.println("不好意思队列已满");
            return;
        }
        arr[rear%maxsize]=value;
        rear++;
    }
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，亲输入数据");
        }
        int data = arr[front % maxsize];
        front++;
        return data;
    }
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("没有数据，队列为空");
        }
        return  arr[front];
    }
}
