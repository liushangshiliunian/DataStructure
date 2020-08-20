import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {

        //创建哈希表
        HashTab hashTab = new HashTab(7);

        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Emp emp = new Emp(name, id);
                    hashTab.addEmp(emp);
                    break;
                case "list":
                    hashTab.showEmplinkedList();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmp(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }
}
 class HashTab{
      private  EmpLinkedList[] empLinkedLists;
      private  int size;

        public  HashTab(int size) {
            this.size = size;
            empLinkedLists=new EmpLinkedList[size];
            for (int i=0;i<size;i++){
                empLinkedLists[i]=new EmpLinkedList();
            }
        }

        public void addEmp(Emp emp){
            int empLinkedListNO = emp.id % size;
            empLinkedLists[empLinkedListNO].add(emp);
        }

        public void showEmplinkedList(){
            for (int i=0;i<size;i++){
                empLinkedLists[i].list(i);
            }
        }

        public void  findEmp(int id){
            Emp emp = empLinkedLists[id % size].findEmp(id);
            if (emp !=null){
                System.out.println(emp);
            }else {
                System.out.println("在哈希表中，没有找到该雇员~");
            }

        }
    }



    class EmpLinkedList{
            private Emp head;

            public void add (Emp emp){
                if (head==null){
                    head=emp;
                    return;
                }
                Emp temp=head;
                while(true){
                    if (temp.next==null){
                        temp.next=emp;
                        break;
                    }
                    temp=temp.next;
                }
            }
            public  void list (int no ){
                if (head ==null){
                    System.out.println("第 "+(no+1)+" 链表为空");
                    return;
                }
                System.out.println("第 "+(no+1)+" 链表信息为：");
                Emp temp=head;
                while(true){
                    System.out.println(temp);
                    if (temp.next==null){
                        break;
                    }

                    temp=temp.next;
                }
            }

            public Emp  findEmp(int id){
                if (head ==null){
                    System.out.println("链表为空");
                    return null;
                }
                Emp temp=head;
                while (true){
                    if (temp.next==null){
                        break;
                    }
                    if (temp.id==id){
                        break;
                    }
                    temp=temp.next;
                }
                return temp;
        }
    }


    class Emp{
        public String name;
        public Integer id;
        public  Emp next;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Emp getNext() {
            return next;
        }

        public void setNext(Emp next) {
            this.next = next;
        }

        public Emp(String name, Integer id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Emp{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }

