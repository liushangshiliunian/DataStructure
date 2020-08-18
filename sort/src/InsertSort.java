import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {

    public static void main(String[] args) {
        int arr[]=new int[10];
        for (int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*800000);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));

        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat2.format(date2));
    }



    public static void insertSort(int [] arr){
            int insertVal=0;
            int insertIndex=0;
            for (int i=1;i<arr.length;i++){
                insertIndex=i-1;
                insertVal=arr[i];
                while (insertIndex>=0&& insertVal<arr[insertIndex]){
                    arr[insertIndex+1]=arr[insertIndex];
                    insertIndex--;
                }
                if (insertIndex+1!=i){
                    arr[insertIndex+1]=insertVal;
                }
            }

    }
}

