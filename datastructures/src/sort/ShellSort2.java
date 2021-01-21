package sort;

import java.util.Arrays;

public class ShellSort2 {
    public static void main(String[] args) {
        int arr[]={5,8,2,9,7,25,-5};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static  void shellSort2(int arr[]) {
        int min=0;
        int index=0;
        for (int gap=arr.length/2;gap>0;gap/=2){
            for (int i=gap;i<arr.length;i++){
                min=arr[i];
                index=gap;
                if (arr[index]<arr[index-gap]){
                while (index-gap>=0&&min<arr[index-gap]){
                    arr[i]=arr[index-gap];
                    i-=gap;
                }
                    arr[index]=min;
                }

            }
        }
    }
}
