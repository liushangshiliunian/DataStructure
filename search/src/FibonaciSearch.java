import java.util.Arrays;

public class FibonaciSearch {
    public static void main(String[] args) {
        int [] arr = {1,8, 10, 89, 1000, 1234};

        System.out.println("index=" + fibonaciSearch(arr, 89));// 0

    }

    public static int[] fivonaci(){
        int max_value=20;
        int[] temp = new int[max_value];
        temp[0]=1;
        temp[1]=1;
        for (int i=2;i<temp.length;i++){
            temp[i]=temp[i-1]+temp[i-2];
        }
        return temp;
    }

    public static int fibonaciSearch(int[] arr ,int value){
        int left=0;
        int right=arr.length-1;
        int k=0;
        int mid=0;
        int f[]=fivonaci();
        while (right >f[k]-1){
            k++;
        }
        int [] temp= Arrays.copyOf(arr,f[k]);
        for (int i=right+1;i<f[k];i++){
            temp[i]=arr[right];
        }
        while(left<=right){
            mid=left+f[k-1]-1;
            if (value<temp[mid]){
                right=mid-1;
                k--;
            }else if (value>temp[mid]){
                left=mid+1;
                k-=2;
            }else{
                if (mid<=right){
                    return mid;
                }else {
                    return right;
                }
            }
        }
        return -1;
    }
}
