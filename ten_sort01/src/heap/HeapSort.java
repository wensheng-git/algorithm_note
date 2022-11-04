package heap;

import java.util.Arrays;

/**
 * @author :zhangwensheng
 * @date : 2022/10/23  0023 17:42
 */
//大根堆
public class HeapSort {
    public static void heapInsert(int[] heap, int index) {
        while (heap[index] > heap[(index - 1) / 2]) {
            swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapIfy(int[] heap, int index, int heapSize) { //每次heapify是未排序的数组长度
        int left = index * 2 + 1;
        while (left < heapSize) {
            // TODO*********这一步尽量给left，由于right不存在，？为false要给left，给left+1下面会越界
            int largestIndex = left + 1 < heapSize && heap[left] < heap[left + 1] ? left+1 : left;

            largestIndex = heap[largestIndex] > heap[index] ? largestIndex : index;

            if (index == largestIndex) return;
            swap(heap, index, largestIndex);
            index = largestIndex;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(int[] arr) {
        // 1:根据数组堆化：
        //      一个一个insert代价是nlogn（树底部多元素都要向上比较）
        //      从数组最后面的元素开始heapify代价是n（树底下多元素去和自己的子辈去比较）....比较的次数较少
        for (int i = arr.length - 1; i>= 0; i--) {
            heapIfy(arr, i, arr.length);
        }

        // 2:排序，把根方放到最后面
        int heapSize = arr.length;
        while (heapSize > 1) {
            swap(arr, 0, --heapSize);// 一次排序完成
            heapIfy(arr, 0, heapSize);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 4, 5, 2, 6, 2, 6, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
