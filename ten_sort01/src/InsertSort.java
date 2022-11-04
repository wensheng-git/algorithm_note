import java.util.Arrays;

/**
 * @author :zhangwensheng
 * @date : 2022/10/22  0022 17:41
 */
/*
*思想: 遍历一次元素,每拿到一个元素,往前插入
* */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr={3,1,2,1,3,53,1,23,5,3,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            for (int j=i;j>0;j--){ //j-1会到达最前一个位置
                if (arr[j]<arr[j-1]) swap(arr,j,j-1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
