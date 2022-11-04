import java.util.Arrays;

/**
 * @author :zhangwensheng
 * @date : 2022/10/22  0022 20:58
 */
/*
 * 定义一个gap,跳着跳着分为几组进行插入排序
 * 逐渐缩短gap为1
 * */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1, 5, 4, 63, 2, 46, 2, 1,};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int h = 1;
        while (h < arr.length / 3) {
            h = h * 3 + 1;//1保证最后gap为1
        }

        for (int gap = h; gap > 0; gap = (gap - 1) / 3) { // gap的循环
            for (int i = gap; i < arr.length; i++) {// 所有元素根据gap来跳着比较
                for (int j = i; j > gap - 1; j--) {// 最前的一组由j-gap去决定
                    if (arr[j] < arr[j - gap]) swap(arr, j, j - gap);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
