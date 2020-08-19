import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {
        int arr[]=new int[8];
        for (int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*800000);
        }
        int[] temp=new int[arr.length];


        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));

        System.out.println(Arrays.toString(arr));
        mergeSort(arr,arr.length-1,0,temp);
        System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat2.format(date2));
    }

    public static void mergeSort(int arr[],int right ,int left,int[] temp){

        if (left<right){
            int mid=(left+right)/2;
            mergeSort(arr,mid,left,temp);
            mergeSort(arr,right,mid+1,temp);
            merge(arr,right,left,mid,temp);
        }
    }

    public static void merge(int []arr ,int right,int left,int mid,int []temp){
                int i=left;
                int j=mid+1;
                int t=0;
            while (i<=mid&&j<=right){

                if (arr[i]<=arr[j]){
                    temp[t]=arr[i];
                    i+=1;
                    t+=1;
                }else {
                    temp[t]=arr[j];
                    j+=1;
                    t+=1;
                }
            }
            while (i<=mid){
                temp[t]=arr[i];
                t+=1;
                i+=1;
            }
            while (j<=right){
                temp[t]=arr[j];
                    t+=1;
                    j+=1;
        }
            t=0;
            int tempLeft=left;
            while (tempLeft<=right){
                arr[tempLeft]=temp[t];
                t+=1;
                tempLeft+=1;
            }
    }
}
