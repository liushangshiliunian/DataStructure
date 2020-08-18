import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        int arr[]=new int[80000];
        for (int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*800000);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));

//        System.out.println(Arrays.toString(arr));
        selectSort(arr);
//        System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat2.format(date2));
    }


    public static void selectSort(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            int min=arr[i];
            int minIndex=i;
            for (int j=1+i;j<arr.length;j++){
                if (min>arr[j]){
                    minIndex=j;
                    min=arr[j];
                }
            }
            if (minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
        }
    }
}
