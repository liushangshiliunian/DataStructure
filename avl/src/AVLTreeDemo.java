public class AVLTreeDemo {
    public static void main(String[] args) {
        //int[] arr = {4,3,6,5,7,8};
        //int[] arr = { 10, 12, 8, 9, 7, 6 };
        int[] arr = { 10, 11, 7, 6, 8, 9 };
        //创建一个 AVLTree对象
        AVLTree avlTree = new AVLTree();
        //添加结点
        for(int i=0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }

        //遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();

        System.out.println("在平衡处理~~");
        System.out.println("树的高度=" + avlTree.getRoot().heightNode()); //3
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftHeight()); // 2
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightHeight()); // 2
        System.out.println("当前的根结点=" + avlTree.getRoot());//8
    }

}

class AVLTree{
    private Node root;

    public Node getRoot() {
        return root;
    }



    @Override
    public String toString() {
        return "binarySortTree{" +
                "root=" + root +
                '}';
    }


    public int delRightTreeMin(Node node){
        Node temp=node;
        while (temp.left!=null){
            temp=temp.left;
        }
        delNode(temp.value);
        return temp.value;
    }

    public void delNode(int value){
        Node node = searchNode(value);
        Node parentNode = parentNode(value);
        if (root==null){
            return;
        }else {
            if (node==null){
                return;
            }
            if (root.left==null&&root.right==null){
                root=null;
                return;
            }
            if (node.left == null && node.right == null) {
                if (parentNode.left !=null&&parentNode.left.value==value) {
                    parentNode.left = null;
                } else if (parentNode.right != null&&parentNode.right.value==value) {
                    parentNode.right = null;
                }
            } else if (node.left != null && node.left != null) {
                int i = delRightTreeMin(node);
                node.value = i;
            } else {
                if (node.left != null) {
                    if (parentNode != null) {
                        if (parentNode.left.value == value) {
                            parentNode.left = node.left;
                        } else {
                            parentNode.right = node.left;
                        }
                    } else {
                        root = node.left;
                    }
                } else {
                    if (parentNode != null) {
                        if (parentNode.left.value == value) {
                            parentNode.left = node.right;
                        } else {
                            parentNode.right = node.right;
                        }
                    } else {
                        root = node.right;
                    }
                }
            }
        }
    }


    public Node searchNode(int value){
        if (root==null){
            System.out.println("树为空，不能查找");
            return null;
        }else {
            return root.searchNode(value);
        }
    }

    public Node parentNode (int value){
        if (root==null){
            System.out.println("树为空，不能查找");
            return null;
        }else {
            return root.parentNode(value);
        }
    }

    public void infixOrder(){
        if (root==null){
            System.out.println("二叉树为空");
        }else {
            root.infixOrder();
        }
    }

    public void add(Node node){
        if (root!=null){
            root.add(node);
        }else {
            root=node;
        }
    }
}

class Node{
    public Node left;
    public Node right;
    public int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public Node(int value) {
        this.value = value;
    }

    public int  heightNode(){
       return Math.max((left==null?0:left.heightNode()),(right==null?0:right.heightNode()))+1;
    }

    public int  leftHeight(){
        if (left!=null) {
            return left.heightNode();
        }else{
            return 0;
        }
    }
    public int  rightHeight(){
        if (right!=null) {
            return right.heightNode();
        }else{
            return 0;
        }
    }

    public void leftRotate(){
        Node node = new Node(this.value);
        node.left=this.left;
        node.right=this.right.left;
        this.value=this.right.value;
        this.right=this.right.right;
        this.left=node;
    }

    public void rightRotate(){
        Node node = new Node(this.value);
        node .right=this.right;
        node.left=this.left.right;
        this.value=this.left.value;
        this.left=this.left.left;
        this.right=node;
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


    public Node parentNode(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.parentNode(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.parentNode(value); //向右子树递归查找
            } else {
                return null; // 没有找到父结点
            }
        }
    }


    public Node searchNode(int value){
        if(this.value>value){
            if (this.left==null){
                System.out.println("没找到目标结点");
                return null;
            }else {
                return   this.left.searchNode(value);
            }
        }else if (this.value<value){
            if (this.right==null){
                System.out.println("没找到目标结点");
                return null;
            }else {
                return this.right.searchNode(value);
            }
        }else {
            return this;
        }
    }


    public void add(Node node) {
        if (node == null) {
            System.out.println("添加的数据不能为空");
            return;
        }
        if (this.value > node.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

        if (rightHeight()-leftHeight()>1){
            if (right!=null&&right.leftHeight()>right.rightHeight()){
                right.rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }
            return;
        }
        if (leftHeight()-rightHeight()>1){
            if (left!=null&&left.rightHeight()>left.leftHeight()){
                left.leftRotate();
                rightRotate();
            }else {
                rightRotate();
            }
        }
    }
}