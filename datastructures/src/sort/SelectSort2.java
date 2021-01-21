package sort;

import java.util.Arrays;

public class SelectSort2 {
    public static void main(String[] args) {
        int arr[]={5,8,2,9,7,25,-5};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectSort(int arr[]){
        int min=0;
        int index=0;
        for (int i = 0; i <arr.length ; i++) {
            min=arr[i];//初始化最小值为arr[i];
            index=i;
            for (int j = i+1; j <arr.length ; j++) {
                if (min>arr[j]){
                    min=arr[j];
                    index=j;
                }

            }
            if (index!=i){//判断找出的最小值索引是否为它本身，不是它本身的话进行置换
                arr[index]=arr[i];
                arr[i]=min;
            }
        }

    }
}
