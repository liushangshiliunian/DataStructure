import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
        int arr[]=new int[800000];
        for (int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*800000);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));

//        System.out.println(Arrays.toString(arr));
        quickSort(0,arr.length-1,arr);
//        System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat2.format(date2));
    }


    public static  void quickSort(int light ,int right,int []arr){
        int r=right ;
        int l=light;
        int pivot=arr[(light+right)/2];
        int temp;
        while(l<r){
            while (arr[l]<pivot){
                l+=1;
            }
            while (arr[r]>pivot){
                r-=1;
            }
            if (l>=r){
                break;
            }

            temp=arr[r];
            arr[r]=arr[l];
            arr[l]=temp;
            if (arr[l]==pivot){
                r-=1;
            }
            if (arr[r]==pivot){
                l+=1;
            }
        }

        if (l==r){
           l+=1;
           r-=1;
        }

        if (light<r){
            quickSort(light,r,arr);
        }

        if (right>l){
            quickSort(l,right,arr);
        }
    }
}
