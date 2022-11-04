import java.util.Arrays;

/**
 * @author :zhangwensheng
 * @date : 2022/10/23  0023 15:46
 */
/*
* bucket[i]的i就是arr[i]
* bucket[i]就是等于i的元素的个数
* 累加的bucket[i]代表小于等于i的个数
* */
public class CountSort {
    public static void main(String[] args) {
        int[] arr={2,1,5,1,5,6,2,1,6,7,2,3,5,4,10,1};
        int[] sort = sort(arr);
        System.arraycopy(sort,0,arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sort(int[] arr){
        //准备桶
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            max=arr[i]>max?arr[i]:max;
        }
        int[] bucket=new int[max+1];// 最大的下标就是max

        //初始化桶
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        for (int i = 1; i < bucket.length; i++) {
            bucket[i]=bucket[i]+bucket[i-1];// bucket[i]记录着小于等于i的个数
        }

        //倒叙遍历，准备排序
        int[] result=new int[arr.length];
        for (int i=arr.length-1;i>=0;i--){
            //bucket[i]=n,n-1就是该桶最后一个入桶的元素，也是该最大的下标，最后入桶的是arr后面的元素，
            result[--bucket[arr[i]]]=arr[i];
        }
        return result;
    }
}
