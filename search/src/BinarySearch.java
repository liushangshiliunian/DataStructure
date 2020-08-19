import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
//            int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,10, 11, 12, 13,14,15,16,17,18,19,20 };


        //
//		int resIndex = binarySearch(arr, arr.length - 1, 0, 10);
//		System.out.println("resIndex=" + resIndex);

                List<Integer> resIndexList = binarySearch2(arr, arr.length - 1,0 , 10);
        System.out.println("resIndexList=" + resIndexList);
    }


    public static int binarySearch(int[] arr ,int right,int left,int findValue){
        int mid =(left+right)/2;
        int midVal = arr[mid];
        if (left>right){
            return -1;
        }
        if (midVal<findValue){
           return   binarySearch(arr,right,mid+1,findValue);
        }
        if (midVal>findValue){
          return   binarySearch(arr,mid-1,left,findValue);
        }else {
            return mid;
        }
    }

    public static List binarySearch2(int[] arr , int right, int left, int findValue){
        int mid =(left+right)/2;
        int midVal = arr[mid];

        ArrayList<Integer> list = new ArrayList<>();
        if (left>right){
            return new ArrayList<Integer>();
        }
        if (midVal<findValue){
            return   binarySearch2(arr,right,mid+1,findValue);
        }
        if (midVal>findValue){
            return   binarySearch2(arr,mid-1,left,findValue);
        }else {
            int temp=mid-1;
            while(true){
                if (temp<0||arr[temp]!=findValue){
                    break;
                }
                list.add(temp);
                temp--;
            }
            list.add(mid);
            temp=mid+1;
            while(true){
                if (temp>arr.length||arr[temp]!=findValue){
                    break;
                }
                list.add(temp);
                temp++;
            }
            return list;
        }
    }
}
