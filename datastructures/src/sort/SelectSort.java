package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        //int arr[]={5,3,25,23,19,87};


        //System.out.println(Arrays.toString(selectSort(arr)));
        int[] arrMax=new  int[80000];
        for (int i = 0; i < 80000; i++) {
            arrMax[i]= (int) (Math.random()*800000);
        }
        Date date1=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date1);
        System.out.println("格式化开始前的时间为"+dateStr);
        selectSort(arrMax);
        Date date2=new Date();

        String date2Str = sdf.format(date2);
        System.out.println("格式化开始前的时间为"+date2Str);
    }
    public static void selectSort(int arr[]){
        int min=0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            min=arr[i];
            index=i;
            for (int j = i+1; j < arr.length; j++){//找出第i后面的数的最小值和索引
                if (arr[j]<min){//判断这个数和后一个数的大小再进行最小数的赋值
                    min=arr[j];
                    index=j;
                }
            }
            if (i!=index){//当判断出的最小值不等于i时则进行交换
                arr[index]=arr[i];
                arr[i]=min;
            }
        }
    }
}
