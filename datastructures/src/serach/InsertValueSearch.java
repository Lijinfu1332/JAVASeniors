package serach;

public class InsertValueSearch {
    public static void main(String[] args) {
        int arr[]=new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i]=i+1;
        }
        int index = insertValueSearch(arr, 0, arr.length-1, 45);
        System.out.println("index="+index);

    }
    public static int insertValueSearch(int[] arr,int left,int right,int searchVal){
        //插值查找算法公示
        int mid=left+(right-left)*(searchVal-arr[left])/(arr[right]-arr[left]);
        if (left>right||searchVal<arr[left]||searchVal>arr[right]){
            return -1;
        }
        if (searchVal>arr[mid]){
            return insertValueSearch(arr,mid+1,right,searchVal);
        }else if (searchVal<arr[mid]){
            return insertValueSearch(arr,left,mid-1,searchVal);
        }else {
            return mid;
        }
    }
}
