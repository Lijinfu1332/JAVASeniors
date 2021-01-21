package sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int arr[]={5,8,9,2,7,4,36};
        inertSort(arr);

    }
    public static  void inertSort(int[] arr){
        for (int i = 1; i <arr.length ; i++) {
            int insertVal=arr[i];//要插入的值
            int index=i-1;
            while (index>=0&&insertVal<arr[index]){//当该数的前一个数据小于要插入的值时进行移位判断
                arr[index+1]=arr[index];
                index--;//索引依次移位到不满足条件
            }
            arr[index+1]=insertVal;//把不满足条件时的索引加1并将该值插入
            System.out.println("第"+i+"轮进行插入排序后的情况:"+ Arrays.toString(arr));
        }
    }
}
