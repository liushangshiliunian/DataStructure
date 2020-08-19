import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {

    public static void main(String[] args) {
        int arr[]=new int[8];
        int arr2[]=new int[]{35,533,4,21,89};
        for (int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*800000);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));

        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat2.format(date2));
    }



    public static void radixSort(int[] arr){
        int max=arr[0];
        for (int i=1;i<arr.length;i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        int maxLength = (max + "").length();
        int [] bucketElementCount=new int [10];

        int [][]bucket=new int [10][arr.length];
        for (int i=0,n=1;i<maxLength;i++,n*=10){
            for (int j=0;j<arr.length;j++){
                int bucketIndex = arr[j] / n % 10;
                bucket[bucketIndex][bucketElementCount[bucketIndex]]=arr[j];
                bucketElementCount[bucketIndex]++;
            }
            int index=0;
            for (int k=0;k<bucketElementCount.length;k++){
                if (bucketElementCount[k]!=0){
                    for (int l=0;l<bucketElementCount[k];l++){
                        arr[index++]=bucket[k][l];
                    }
                }
                bucketElementCount[k]=0;
            }

        }
    }
}
