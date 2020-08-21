public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        HeroNode root =new HeroNode(1,"宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        HeroNode node6 = new HeroNode(6, "武松");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node6);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);

//        binaryTree.preOrderList();

//        binaryTree.infixOrderList();

        binaryTree.postOrderList();

//        HeroNode heroNode = binaryTree.preOrderSearch(5);
//         HeroNode heroNode = binaryTree.infixOrderSearch(5);
//        HeroNode heroNode = binaryTree.postOrderSearch(5);
//        if (heroNode!=null){
//            System.out.println(heroNode);
//        }else {
//            System.out.println("没有找到相对应的节点");
//        }

//        binaryTree.delHearNo(5);
//        binaryTree.delHearNo(3);
//        binaryTree.preOrderList();

    }

}

class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
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