public class InsertValueSearch {

    public static void main(String[] args) {

//		int [] arr = new int[100];
//		for(int i = 0; i < 100; i++) {
//			arr[i] = i + 1;
//		}

        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };

        int index = insertSearch(arr, 1234, 0, arr.length-1);
        //int index = binarySearch(arr, 0, arr.length, 1);
        System.out.println("index = " + index);

        //System.out.println(Arrays.toString(arr));
    }

    public static int  insertSearch(int []arr ,int value,int left,int right) {
        int r = right;
        int l = left;

        if (left > right || value < arr[0] || value > arr[arr.length - 1]) {
            return -1;
        }
            int mid = left + (value - arr[l]) / (arr[r] - arr[l]) * (right-left);
              int valueMid=arr[mid];
            if (value > valueMid) {
                return insertSearch(arr, value, mid + 1, right);
            } else if (value < valueMid) {
                return insertSearch(arr, value, left, mid - 1);
            } else {
                return mid;
            }
        }
}
