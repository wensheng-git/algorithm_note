import java.util.Arrays;

/**
 * @author :zhangwensheng
 * @date : 2022/10/22  0022 21:43
 */
/*
* 选择一个pivot,换到最后的一个位置
* 小于区域从-1开始扩,大于区域从pivot开始扩
*
* 一指针i开始遍历
*    ==直接跳过
*    <则小于区++,然后交换,i++
*    >则大于区--,然后交换,i不变
*    一直到i=大于区指针
*
* 在partition子数组
* */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr={2,21,1,5,6,1,2,46,4,2,3,10};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr,int left,int right){
        if (left>right) return;
        swap(arr,left+(int)(Math.random()*(right-left+1)),right);// 随机化
        int[] equalArea=partition(arr,left,right);

        sort(arr,left,equalArea[0]-1);
        sort(arr,equalArea[1]+1,right);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int[] partition(int[] arr,int left,int right){
        int pivot=arr[right];
        int leftPtr=left-1;// 小于区
        int rightPtr=right;// 大于区
        int i=left;// partition不仅仅从0开始
        while(i<rightPtr){
            if (arr[i]==pivot) i++;
            else if (arr[i]<pivot) swap(arr,++leftPtr,i++);
            else swap(arr,i,--rightPtr);
        }
        swap(arr,i,right);
        return new int[]{leftPtr+1,i};// 返回等于边界数组

    }

}
