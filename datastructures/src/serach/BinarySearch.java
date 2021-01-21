package serach;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[]={12,25,38,59,69,71,71,71,71,71,785,799};
        ArrayList<Integer> search2 = binarySearch2(arr, 0, arr.length - 1, 71);
        System.out.println("resIndex="+search2);

    }
    public static int binarySearch(int[] arr,int left,int right,int finVal){
        int mid=(left+right)/2;
        if (left>right){
            return -1;//表示没有找到
        }
        if (finVal>arr[mid]){//向右递归
            return binarySearch(arr,mid+1,right,finVal);
        }else if(finVal<arr[mid]){//向左递归
            return binarySearch(arr,left,mid-1,finVal);
        }else {
            return mid;
        }
    }

    /**
     * 查找多个值
     * @param arr
     * @param left
     * @param right
     * @param finVal
     * @return
     */
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int finVal){
        int mid=(left+right)/2;
        if (left>right){
            return new ArrayList<>();//表示没有找到，返回空数组
        }
        if (finVal>arr[mid]){//向右递归
            return binarySearch2(arr,mid+1,right,finVal);
        }else if(finVal<arr[mid]){//向左递归
            return binarySearch2(arr,left,mid-1,finVal);
        }else {
            //创建一个数组用于存储索引
            ArrayList<Integer> resultIndexList=new ArrayList<>();
            resultIndexList.add(mid);
            int temp=mid-1;
            while (true){//向左查找
                if (temp<0||arr[temp]!=finVal){
                    break;
                }
                resultIndexList.add(temp);
                temp--;
            }
            temp=mid+1;
            while (true){//向右查找
                if (temp>right||arr[temp]!=finVal){
                    break;
                }
                resultIndexList.add(temp);
                temp++;
            }

            return resultIndexList;
        }
    }
}
