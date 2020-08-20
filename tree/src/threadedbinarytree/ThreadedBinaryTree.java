package threadedbinarytree;

public class ThreadedBinaryTree {
    public static void main(String[] args) {

            //测试一把中序线索二叉树的功能
            HeroNode root = new HeroNode(1, "tom");
            HeroNode node2 = new HeroNode(3, "jack");
            HeroNode node3 = new HeroNode(6, "smith");
            HeroNode node4 = new HeroNode(8, "mary");
            HeroNode node5 = new HeroNode(10, "king");
            HeroNode node6 = new HeroNode(14, "dim");

            //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
            root.setLeft(node2);
            root.setRight(node3);
            node2.setLeft(node4);
            node2.setRight(node5);
            node3.setLeft(node6);

            //测试中序线索化
        ThreadedBinaryTreeTest threadedBinaryTree = new ThreadedBinaryTreeTest();
            threadedBinaryTree.setRoot(root);
            threadedBinaryTree.threadedNodes();

            //测试: 以10号节点测试
            HeroNode leftNode = node5.getLeft();
            HeroNode rightNode = node5.getRight();
            System.out.println("10号结点的前驱结点是 ="  + leftNode); //3
            System.out.println("10号结点的后继结点是="  + rightNode); //1

            //当线索化二叉树后，能在使用原来的遍历方法
            //threadedBinaryTree.infixOrder();
            System.out.println("使用线索化的方式遍历 线索化二叉树");
            threadedBinaryTree.threadedList(); // 8, 3, 10, 1, 14, 6


    }
}

class ThreadedBinaryTreeTest{
    private HeroNode root;

    private  HeroNode pre;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    public void threadedList(){
        HeroNode node=root;

        while (node!=null){
            while(node.getLeftType()==0){
                node=node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);
            }
            node=node.getRight();
        }

    }

    public void threadedNodes(HeroNode node){
        if (node==null){
            return;
        }
        threadedNodes(node.getLeft());

        if (node.getLeft()==null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre!=null&&pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre=node;

        threadedNodes(node.getRight());
    }


    public void preOrderList( ){
        if (root == null ){
            System.out.println("二叉树为空，不能遍历");
        }else{
            this.root.preOrder();
        }
    }
    public void infixOrderList( ){
        if (root == null ){
            System.out.println("二叉树为空，不能遍历");
        }else{
            this.root.infixOrder();
        }
    }
    public void postOrderList( ){
        if (root == null ){
            System.out.println("二叉树为空，不能遍历");
        }else{
            this.root.postOrder();
        }
    }

    public HeroNode preOrderSearch(int no ){
        if (root ==null){
            return null;
        }else {
            return this.root.preOrderSearch(no);
        }
    }
    public HeroNode infixOrderSearch(int no ){
        if (root.getLeft() ==null){
            return null;
        }else {
            return this.root.infixOrderSearch(no);
        }
    }
    public HeroNode postOrderSearch(int no ){
        if (root ==null){
            return null;
        }else {
            return this.root.postOrderSearch(no);
        }
    }


    public void delHearNo(int no ){
        if (root ==null){
            System.out.println("空树不能删除");
        }else {
            if (root.getNo()==no){
                root=null;
            }else {
                root.del(no);
            }
        }
    }
}

 class HeroNode{
    private int no ;
    private String name;
    private HeroNode left;
    private HeroNode right;

    private int leftType;
    private int rightType;

     public int getLeftType() {
         return leftType;
     }

     public void setLeftType(int leftType) {
         this.leftType = leftType;
     }

     public int getRightType() {
         return rightType;
     }

     public void setRightType(int rightType) {
         this.rightType = rightType;
     }

     public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }

    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOrder();
        }
    }

    public  void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if (this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public HeroNode preOrderSearch(int no ){
        System.out.println("进入前序查找");
        if (this.no==no){
            return  this;
        }
        HeroNode resNode=null;
        if (this.left!=null){
            resNode= this.left.preOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.right!= null){
            resNode=this.right.preOrderSearch(no);
        }

        return resNode;

    }

    public HeroNode infixOrderSearch(int no ){

        HeroNode resNode=null;
        if (this.left!=null){
            resNode= this.left.infixOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        System.out.println("进入中序查找");

        if (this.no==no){
            return  this;
        }
        if (this.right!= null){
            resNode=this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode postOrderSearch(int no ){

        HeroNode resNode=null;

        if (this.left!=null){
            resNode= this.left.postOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }

        if (this.right!= null){
            resNode=this.right.postOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }

        System.out.println("进入后序查找");

        if (this.no==no){
            return  this;
        }
        return resNode;
    }

    public void del(int no ){
        if(this.left!=null&&this.left.no==no){
            this.left=null;
            return;
        }
        if(this.right!=null&&this.right.no==no){
            this.right=null;
            return;
        }
        if (this.left!=null){
            this.left.del(no);
        }
        if (this.right!=null){
            this.right.del(no);
        }
    }

}

