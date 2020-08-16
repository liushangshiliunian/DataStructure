package com.atguigu;

import com.sun.javaws.IconUtil;
import com.sun.xml.internal.ws.wsdl.writer.UsingAddressing;

import javax.management.StandardEmitterMBean;
import java.util.List;
import java.util.Stack;

public class SingleLinkedList {

    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");


        SingleLinkedList2 list2 = new SingleLinkedList2();

        list2.SingleLinkedList2(heroNode1);
        list2.SingleLinkedList2(heroNode3);
        list2.SingleLinkedList2(heroNode2);
        list2.SingleLinkedList2(heroNode4);

        list2.updateList(new HeroNode(2,"小卢","玉麒麟~~"));

//        list2.deleteList(1);
//        list2.deleteList(4);

//        System.out.println(list2.getLength(list2.getHead()));

//        System.out.println(list2.findLastIndexNode(list2.getHead(), 1)+"\n");
//           这种倒装破坏了单链表的结构
//        list2.reversetList(list2.getHead());
//        栈方式倒装没有破坏链表结构
         list2.reversePrint(list2.getHead());

//        list2.list();
    }



}
class  SingleLinkedList2{
      HeroNode head=  new HeroNode(0,"","");

      public HeroNode getHead(){
          return head;
      }

      public void sumLiked(){

      }


      public static void reversePrint(HeroNode head){
          if (head.next==null||head.next.next==null){
              return;
          }
          Stack<HeroNode> stack = new Stack<HeroNode>();
          HeroNode temp=head.next;
          while(true){
                if (temp==null){
                    break;
                }
                stack.push(temp);
                temp=temp.next;
          }
          while(stack.size()>0){
              System.out.println(stack.pop());
          }
      }


      public static  void  reversetList(HeroNode head){
          if (head.next==null||head.next.next==null){
              return;
          }
          HeroNode rever = new HeroNode(0, "", "");
          HeroNode temp=head.next;
          HeroNode cur;
          while (true){
              if (temp==null){
                 break;
              }
              cur=temp.next;
              temp.next=rever.next;
              rever.next=temp;
              temp=cur;
          }
          head.next=rever.next;
      }


      public static HeroNode findLastIndexNode(HeroNode head,int index){
            if (head.next==null){
                return null;
            }
            HeroNode temp=head.next;
          int length = getLength(head);
          if (index>length||index<0){
              return null;
          }
         int size = length-index;
          for (int i=0;i<size;i++){
              temp=temp.next;
              }
          return temp;
          }


      public  static int  getLength(HeroNode head){
         if (head.next==null){
             return  0;
         }
         int length=0;
         HeroNode temp=head;
         while(true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
            length++;
         }
         return length;
      }

        public  void deleteList(int no){
          HeroNode temp=head;
          boolean loop=false;
          while(true){
              if (temp.next==null){
                  break;
              }
              if (temp.next.no==no){
                  loop=true;
                  break;
              }
              temp=temp.next;
          }
          if (loop){
              temp.next=temp.next.next;
          }else {
              System.out.println("要删除的节点不存在");
          }
        }


      public void updateList(HeroNode heroNode){
          HeroNode temp=head;
          boolean loop=false;
          while(true){
              if (temp.next==null){
                  break;
              }
              if (temp.no==heroNode.no){
                  loop=true;
                  break;
              }
              temp=temp.next;
          }
          if (loop){
              temp.no=heroNode.no;
              temp.heroName=heroNode.heroName;
              temp.nickname=heroNode.nickname;
          }else {
              System.out.println("你要修改的节点不存在");
          }
      }



       public void addSingleLinked(HeroNode heroNode){
          HeroNode temp=head;
          while(true){
              if (temp.next==null){
                  break;
              }
              temp=temp.next;
          }
          temp.next=heroNode;
     }

        public void SingleLinkedList2(HeroNode heroNode){

          HeroNode temp= head;
          boolean flag=false;
          while (true){
              if (temp.next==null){
                  break;
              }
              if (temp.next.no>heroNode.no){
                  break;
              }else if (temp.next.no==heroNode.no){
                  flag=true;
                  break;
              }
              temp=temp.next;
          }
          if (flag){
              System.out.printf("准备插入的英雄编号 %d 已经存在\n",heroNode.no);
          }else {
              heroNode.next=temp.next;
                temp.next=heroNode;
          }
     }



        public void list(){
          if (head.next==null){
              System.out.println("链表为空");
              return;
          }
          HeroNode temp=head.next;
          while (true){
              if (temp==null){
                  break;
              }
              System.out.println(temp);
              temp=temp.next;
          }
        }
}
class HeroNode{
    public int no;
    public String heroName;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String heroName, String nickname) {
        this.no = no;
        this.heroName = heroName;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", heroName='" + heroName + '\'' +
                ", nickname='" + nickname + "}";
    }
}
