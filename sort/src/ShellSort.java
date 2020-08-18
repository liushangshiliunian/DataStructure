import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

//        shellSort(arr); //交换式
        shellSort2(arr);//移位方式

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

        System.out.println(Arrays.toString(arr));
    }




    public static void shellSort(int [] arr){
        int temmp=0;
        int count=0;
        for (int gap=arr.length/2;gap>0;gap/=2){
                for (int i =gap;i<arr.length;i++){
                    for (int j=i-gap;j>=0;j-=gap){
                       if (arr[j] > arr[j + gap]){
                            temmp=arr[j];
                            arr[j]=arr[j+gap];
                            arr[j+gap]=temmp;
                        }
                    }
                }
        }
    }

    public static void shellSort2(int [] arr){
        for (int gap=arr.length/2;gap>0;gap/=2){
            for (int i=gap;i<arr.length;i++){
                int j=i;
                int temp=arr[j];
                if (arr[j]<arr[j-gap]){
                    while (j-gap>=0&&temp<arr[j-gap]){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    arr[j]=temp;
                }
            }
        }
    }
}

