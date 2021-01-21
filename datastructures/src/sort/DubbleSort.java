package sort;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DubbleSort {
    public static void main(String[] args) {
        //创建1个数组
        int[] arrMax=new  int[80000];
        for (int i = 0; i < 80000; i++) {
            arrMax[i]= (int) (Math.random()*800000);
        }
        Date date1=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date1);
        System.out.println("格式化开始前的时间为"+dateStr);
        bullbleSort(arrMax);
        Date date2=new Date();

        String date2Str = sdf.format(date2);
        System.out.println("格式化开始前的时间为"+date2Str);

    }
    public static void bullbleSort(int arr[]){
        boolean flag=false;
        //辅助变量，用于置换位置的
        int temp=0;
        for (int i = 0; i <arr.length-1; i++) {
            for (int j = 0; j <arr.length-i-1 ; j++) {
                if (arr[j] >arr[j+1]) {
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if (!flag){
                break;
            }else {
                flag=false;
            }
        }
    }
}
