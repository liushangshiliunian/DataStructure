import javax.management.StandardEmitterMBean;
import java.beans.SimpleBeanInfo;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
            int[] arr=new int [80000];
            for (int i=0;i<80000;i++){
                arr[i]=(int) (Math.random() * 80000000);
            }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));

//        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat2.format(date2));

    }


    public static void bubbleSort(int [] arr){
        boolean flag=true;
        for (int i=0;i<arr.length-1;i++){
            int temp=0;
            for (int j=0;j<arr.length-1-i;j++){
                if (arr [j]>arr [j+1]){
                    flag=false;
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
            if (flag){
                break;
            }else{
                flag=true;
            }
        }
    }
}
