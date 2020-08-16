package com.atguigu;

public class DoubleLikedList {
    public static void main(String[] args) {
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4, "林冲", "豹子头");


        DoubleLinkedList list2 = new DoubleLinkedList();

        list2.addByOrderNo(heroNode1);
        list2.addByOrderNo(heroNode3);
        list2.addByOrderNo(heroNode2);
        list2.addByOrderNo(heroNode4);

        list2.updateLinked(new HeroNode2(2,"小卢","玉麒麟~~"));

//        list2.deleteDoubleLinked(1);
//        list2.deleteDoubleLinked(4);

//        System.out.println(list2.getLength(list2.getHead()));

//        System.out.println(list2.findLastIndexNode(list2.getHead(), 1)+"\n");
//           这种倒装破坏了单链表的结构
//        list2.reversetList(list2.getHead());
//        栈方式倒装没有破坏链表结构

        list2.listLinked();
    }
}

class DoubleLinkedList{
       HeroNode2 head=new HeroNode2(0,"","");

       public HeroNode2 getHeadNode(){
           return  head;
       }

       public  void  addByOrderNo(HeroNode2 heroNode2){
           HeroNode2 temp=head;
           boolean flag=false;
           while(true){
               if (temp.next==null){
                   break;
               }
               if (temp.next.no > heroNode2.no){
                   break;
               }else if (heroNode2.no==temp.next.no){
                    flag=true;
                    break;
               }
               temp=temp.next;
           }
           if (flag){
               System.out.println("节点已存在不能添加");
           }else{
               if (temp.next!=null){
                     temp.next.pre=heroNode2;
                     heroNode2.next=temp.next;
               }
                     heroNode2.pre=temp;
                    temp.next=heroNode2;
               }
           }


       public void deleteDoubleLinked(int no){
           if (head.next==null){
               System.out.println("链表为空");
               return;
           }
           HeroNode2 temp=head.next;
           boolean flag=false;
           while (true){
               if (temp==null){
                   break;
               }
               if (temp.no==no){
                   flag=true;
                   break;
               }
               temp=temp.next;
           }
           if (flag){
               if (temp.next!=null) {
                   temp.next.pre = temp.pre;
               }
               temp.pre.next=temp.next;
           }else{
               System.out.println("没找到你要删除的节点");
           }

       }


       public void updateLinked(HeroNode2 heroNode2){
           if (head.next==null){
               System.out.println("链表为空");
               return;
           }
           HeroNode2 temp=head.next;
           boolean flag=false;
           while(true){
               if (temp==null){
                   break;
               }
               if (temp.no==heroNode2.no){
                   flag=true;
                   break;
               }
               temp= temp.next;
           }
           if (flag){
               temp.heroName=heroNode2.heroName;
               temp.nickname=heroNode2.nickname;
           }else{
               System.out.println("没有找到相对应的节点");
           }
       }



      public void listLinked(){
           if (head.next==null){
              System.out.println("链表为空");
              return;
          }
          HeroNode2 temp=head.next;
          while(true){
              if (temp==null){
                  break;
              }
              System.out.println(temp);
              temp=temp.next;
          }
      }

       public void addLinked(HeroNode2 heroNode){
          HeroNode2 temp=head;
          while(true){
              if (temp.next==null){
                  break;
              }
              temp=temp.next;
          }
              temp.next=heroNode;
              heroNode.pre=temp;
       }
}


class HeroNode2{
    public int no;
    public String heroName;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String heroName, String nickname) {
        this.no = no;
        this.heroName = heroName;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", heroName='" + heroName + '\'' +
                ", nickname='" + nickname + "}";
    }
}