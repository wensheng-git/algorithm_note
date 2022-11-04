import java.util.Arrays;

/**
 * @author :zhangwensheng
 * @date : 2022/10/22  0022 17:31
 */
/*
 * 思想:
 * 一次遍历找到最小元素的位置(交换好操作),和未最后一个位置交换
 * 遍历n-1次
 * */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 1, 1, 3, 0, 9, 2, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[minPos] < arr[j] ? minPos : j;
            }
            swap(arr, i, minPos);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
