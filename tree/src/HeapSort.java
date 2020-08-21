import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort {
    public static void main(String[] args) {
        //要求将数组进行升序排序
        //int arr[] = {4, 6, 8, 5, 9};
        // 创建要给80000个的随机的数组
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        heapSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
//        System.out.println("排序后=" + Arrays.toString(arr));
    }
    public static void heapSort(int arr[]){
        int temp=0;
        for (int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,arr.length,i);
        }
        for (int j=arr.length-1;j>0;j--){
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,j,0);
        }
    }


    public static void adjustHeap(int [] arr ,int length,int i){
        int temp=arr[i];
        for (int k=i*2+1;k<length;k=k*2+1){
            if (k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            if (arr[k]>temp){
             arr[i]=arr[k];
             i=k;
            }else {
                break;
            }
        }
        arr[i]=temp;
    }
}
