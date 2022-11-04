import java.util.Arrays;

/**
 * @author :zhangwensheng
 * @date : 2022/10/22  0022 17:18
 */
/*
 * 冒泡思想
 * 一次遍历相互交换,把最大的值沉入后面
 * 遍历n-1次
 * */
public class Bubble {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { // n-1次遍历
            for (int j = i; j < arr.length - 1; j++) { // j+1会到达最后一个元素
                if (arr[j] > arr[j + 1]) swap1(arr, j, j + 1);
            }
        }
    }

    public static void swap1(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap2(int[] arr, int i, int j) {//局限:如果是i==j,会到导致变为0
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    public static void main(String[] args) {
        int[] arr={3,1,2,5,4,7,3,5,3,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
