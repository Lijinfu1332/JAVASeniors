package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
    int[] arr={5,8,9,7,4,3,2,0};
    shellSort2(arr);
        int[] arrMax=new  int[80000];
        for (int i = 0; i < 80000; i++) {
            arrMax[i]= (int) (Math.random()*800000);
        }
        Date date1=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date1);
        System.out.println("格式化开始前的时间为"+dateStr);
        shellSort(arrMax);
        Date date2=new Date();

        String date2Str = sdf.format(date2);
        System.out.println("格式化开始前的时间为"+date2Str);
    }
    public static void shellSort(int[] arr){
        int temp=0;
        int count=0;
        for (int gap=arr.length/2;gap>0;gap/=2){//外层进行分组，然后再进行排序
            for (int i = gap; i <arr.length ; i++) {//进行arr.length-gap次比较
                for (int j =i-gap; j >=0; j-=gap) {
                    if (arr[j]>arr[j+gap]){
                        temp=arr[j+gap];
                        arr[j+gap]=arr[j];
                        arr[j]=temp;
                    }
                }
            }

        }
    }
    public static void shellSort2(int[] arr){//使用移动排序法，本质上时插入排序
        int count=0;
        for (int gap=arr.length/2;gap>0;gap/=2){//外层进行分组，然后再进行排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }
            }
           // System.out.println("第"+(++count)+"次交换后"+ Arrays.toString(arr));
        }
    }
}
