import java.util.Arrays;

/**
 * @author :zhangwensheng
 * @date : 2022/10/23  0023 16:11
 */
/*
* 多次的计数排序，有多少位就排序多少次，每排完一次就copy一次，桶永远是10，0~9，每次借助division去得到具体的位置的数字
* */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr={13,321,353,135,642,234,461,752,344,246,642};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int getBit(int i){
        int bit=0;
        while(i!=0){
            i=i/10;
            bit++;
        }
        return bit;
    }

    public static void sort(int[] arr){
        int maxBit=0;
        for (int i = 0; i < arr.length; i++) {
            maxBit=getBit(arr[i])>maxBit?getBit(arr[i]):maxBit;
        }

        for (int i = 0; i < maxBit; i++) {// 计数排序的次数
            int[] bucket=new int[10];
            // 个 十 百
            int division=(int)Math.pow(10,i);

            for (int j = 0; j < arr.length; j++) {
                int num=arr[j]/division%10;
                bucket[num]++;
            }
            for (int k = 1; k < bucket.length; k++) {
                bucket[k]=bucket[k]+bucket[k-1];
            }

            int[] result=new int[arr.length];
            for (int m = arr.length-1; m >=0; m--) {
                int num=arr[m]/division%10;
                result[--bucket[num]]=arr[m];
            }

            // 多了一步，复制回去，并且清空bucket[每次new就是清空]
            System.arraycopy(result,0,arr,0,arr.length);

        }


    }
}
