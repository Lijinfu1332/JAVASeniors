package sort;

import java.util.Arrays;

public class InsertSort2 {
    public static void main(String[] args) {
        int arr[]={5,8,2,9,7,25,-5};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int[] arr){
        int min=0;
        int index=0;
        for (int i=1;i<arr.length;i++){
        for (int j=i;j<arr.length;j++){
            min =arr[j];
            index=j-1;
           while (index>=0&&min<arr[index]){
                arr[j]=arr[index];
                index--;
           }
           arr[index+1]=min;
        }
        }
    }
}
