package sort;

import java.util.Arrays;

public class RedixSort {
    public static void main(String[] args) {
        int arr[] = { 53, 3, 542, 748, 14, 214};
        redixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void redixSort(int[] arr){
        //定义桶
        int buket[][]=new int[10][arr.length];
        //定义用于存放桶中数据的个数
        int elementCount[]=new int[10];
        //查找原数组中的最大数
        int max=arr[0];
        for (int i =1; i < arr.length; i++) {
            if (max<arr[i]){
                max=arr[i];
            }
        }
        //获取到最大数的长度
        int maxLength=(max+"").length();
        //把数存入桶中
        for (int i = 0,n=1; i < maxLength; i++,n*=10) {
            for (int j=0;j<arr.length;j++){
                //获取每个元素对应位的值
                int digitElement=arr[j]/n%10;
                //将原数组中的数存放到对应的桶中
                buket[digitElement][elementCount[digitElement]]=arr[j];
                //每个桶中元素加1，计数也随之相加
                elementCount[digitElement]++;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index=0;
            //将桶内的数还原到数组中
            for (int k = 0; k <elementCount.length ; k++) {
                //如果桶中计数不等于0，再把数据添加到原数组中
                if (elementCount[k]!=0){
                    for (int j = 0; j < elementCount[k]; j++) {
                        //将数据添加到数组内
                        arr[index++]=buket[k][j];
                    }
                    //第i+1轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
                    elementCount[k] = 0;
                }

            }
        }

    }
}
