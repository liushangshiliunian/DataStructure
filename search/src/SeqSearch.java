import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = { 1, 9,1, 11, -1, 34, 89 };// 没有顺序的数组
        List list = seqSearch(arr, 10);

        if(list.isEmpty()) {
            System.out.println("没找到哦啊");
        } else{
            System.out.println(list.toString());
        }
       }




    public static List<Integer> seqSearch(int []arr, int value){
        int index=0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            if (arr[i]==value) {
                list.add(i);
            }
        }

        return list;
    }
}
