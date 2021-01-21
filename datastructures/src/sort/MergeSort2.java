package sort;

import java.util.Arrays;

public class MergeSort2 {
    public static void main(String[] args) {
        int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 };
        int[] temp=new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));

    }
    //合+分
    public static void mergeSort(int arr[],int left,int right,int temp[]){
        temp=new int[arr.length];
        if (left<right){
            int mid=(left+right)/2;//中间索引值
            //给左边的数组进行分解
            mergeSort(arr,left,mid,temp);
            //给右边的数组进行分解
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,right,mid,temp);

        }
    }

    /**
     *
     * @param arr:原始数组
     * @param left：左边的数组最开始索引
     * @param right：右数组的最左边索引
     * @param mid：中值
     * @param temp：临时数组
     */
    public static void merge(int[] arr,int left,int right,int mid,int temp[]){
        int i=left;
        int j=mid+1;
        int t=0;
        temp=new int[arr.length];
        //将数组合并到零时数组
        while (i<=mid&&j<=right){
            //将左边的数据拷贝到数组
            if(arr[i]<=arr[j]){
                temp[t]=arr[i];
                i+=1;
                t+=1;
            }else {//反之将右边的拷到数组
                temp[t]=arr[j];
                j+=1;
                t+=1;
            }
        }
        //(二)
        //把有剩余数据的一边的数据依次全部填充到temp
        //左边的数据拷贝到数组
        while (i<=mid){
            temp[t]=arr[i];
            i+=1;
            t+=1;
        }
        //右边的数据拷贝到数组
        while (j<=right){
            temp[j]=arr[j];
            j+=1;
            t+=1;
        }
        //(三)
        //将temp数组中的元素拷贝回原数组arr
        t=0;
        int tempLeft=0;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;
        }

    }
}
