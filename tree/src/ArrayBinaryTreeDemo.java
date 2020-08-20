import java.util.ArrayList;
import java.util.Arrays;

public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);

//        arrayBinaryTree.preOrder();
//        arrayBinaryTree.infixOrder();
        arrayBinaryTree.postOrder();
    }

}

class ArrayBinaryTree{
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }
    public void preOrder(){
        this.preOrder(0);
    }
    public void infixOrder(){
        this.infixOrder(0);
    } public void postOrder(){
        this.postOrder(0);
    }

    @Override
    public String toString() {
        return "ArrayBinaryTree{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    public void preOrder(int index){
        if (arr==null||arr.length==0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        System.out.println(arr[index]);
        if ((index*2+1)<arr.length){
            preOrder(2*index+1);
        }
        if ((index*2+2)<arr.length){
            preOrder(2*index+2);
        }
    }
    public void infixOrder(int index){
        if (arr==null||arr.length==0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        if ((index*2+1)<arr.length){
            infixOrder(2*index+1);
        }
        System.out.println(arr[index]);
        if ((index*2+2)<arr.length){
            infixOrder(2*index+2);
        }
    }
    public void postOrder(int index){
        if (arr==null||arr.length==0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        if ((index*2+1)<arr.length){
            postOrder(2*index+1);
        }

        if ((index*2+2)<arr.length){
            postOrder(2*index+2);
        }
        System.out.println(arr[index]);
    }
}