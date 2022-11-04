import java.util.Arrays;

/**
 * @author :zhangwensheng
 * @date : 2022/10/22  0022 21:21
 */
/*
 *  数组用mid一分为2 ,让两个数组变得有序,再去合并
 *  合并两个有序数组:左指针,右指针,边界(左边界=右指针-1)
 *
 * Ps:它是一个没有比较交换的算法
 * */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr={2,3,1,4,1,3,6,10,2,7};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        if (left == right) return;
        int mid = left + (right - left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr,left,mid+1,right);
    }

    public static void merge(int[] arr,int leftPtr,int rightPtr,int rightBound){
        // prepare
        int[] temp=new int[rightBound-leftPtr+1];
        int k=0;
        int mid=rightPtr-1;
        int left=leftPtr;// copy的时候需要
        // merge
        while(leftPtr<=mid&&rightPtr<=rightBound)
            temp[k++]=arr[leftPtr]<=arr[rightPtr]?arr[leftPtr++]:arr[rightPtr++];// <=保证稳定性
        while(leftPtr<=mid)
            temp[k++]=arr[leftPtr++];
        while(rightPtr<=rightBound)
            temp[k++]=arr[rightPtr++];
        // copy
        for (int i = 0; i < temp.length; i++) {
            arr[left+i]=temp[i];
        }
    }
}
