import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class HuffManTree {
    public static void main(String[] args) {
            int []arr={13, 7, 8, 3, 29, 6, 1};
        Node node = creatHuffManTree(arr);
        preOrder(node);

    }

    public static void preOrder(Node root){
        if (root==null){
            System.out.println("树为空，不能遍历");
        }else {
            root.preSort();
        }
    }


    public static Node creatHuffManTree(int []arr){
        ArrayList<Node> nodes = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            nodes.add(new Node(arr[i]));
        }
       while(nodes.size()>1) {

           Collections.sort(nodes);
           Node left = nodes.get(0);
           Node right = nodes.get(1);

           Node parent = new Node(left.value + right.value);
           parent.left = left;
           parent.right = right;

           nodes.remove(left);
           nodes.remove(right);

           nodes.add(parent);

       }
       return nodes.get(0);
    }
}


class Node implements Comparable<Node> {
    public int value;
    public  Node left;
    public  Node right;

    public Node(int value) {
        this.value = value;
    }

    public  void preSort(){


        System.out.println(this);
        if (this.left!=null){
            this.left.preSort();
        }
        if (this.right!=null){
            this.right.preSort();
        }
    }



    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }


    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }
}
