public class BinarySrotTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环的添加结点到二叉排序树
        for(int i = 0; i< arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树~");
        binarySortTree.infixOrder(); // 1, 3, 5, 7, 9, 10, 12

        //测试一下删除叶子结点


        binarySortTree.delNode(12);


        binarySortTree.delNode(5);
        binarySortTree.delNode(10);
        binarySortTree.delNode(2);
        binarySortTree.delNode(3);

        binarySortTree.delNode(9);
        binarySortTree.delNode(1);
        binarySortTree.delNode(7);


        System.out.println("root=" + binarySortTree.getRoot());


        System.out.println("删除结点后");
        binarySortTree.infixOrder();
    }
}

class BinarySortTree{
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



class Node {
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

    }
}
