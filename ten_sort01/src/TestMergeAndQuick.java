import java.util.Arrays;

/**
 * @author :zhangwensheng
 * @date : 2022/10/23  0023 13:20
 */
public class TestMergeAndQuick {
    public static void main(String[] args) {
        int[] arr={3,2,1,5,1,6,1,5,6,16};
        sort2(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr, int left,int right){
        if (left==right) return; // 用两个元素去思考边界
        int mid=left+(right-left)/2; // mid让左右边数组有序,然后merge
        sort(arr,left,mid);
        sort(arr,mid+1,right);
        merge(arr,left,mid+1,right);
    }
    public static void sort2(int[] arr,int left,int right){
        if (left>=right) return; // 用两个元素的时候去思考边界
        swap(arr,left+(int)(Math.random()*(right-left+1)),right);
        int[] equalArea=partition(arr,left,right); //partition分割左右数组,继续partition
        sort(arr,left,equalArea[0]-1);
        sort(arr,equalArea[1]+1,right);
    }
    public static int[] partition(int[] arr,int left,int right){
        int leftPtr=-1;
        int rightPtr=right;
        int i=left;
        int pivot=arr[right];
        while(i<rightPtr){
            if (arr[i]==pivot) i++;
            else if(arr[i]<pivot) swap(arr,++leftPtr,i++);
            else swap(arr,--rightPtr,i);
        }
        swap(arr,i,right);
        return new int[]{leftPtr+1,i};
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void merge(int[] arr,int leftPtr,int rightPtr,int right){
        int[] temp=new int[right-leftPtr+1];
        int k=0;
        int mid=rightPtr-1;
        int left=leftPtr;//需要保存去copy
        while(leftPtr<=mid&&rightPtr<=right)
            temp[k++]=arr[leftPtr]<=arr[rightPtr]?arr[leftPtr++]:arr[rightPtr++];
        while(leftPtr<=mid)
            temp[k++]=arr[leftPtr++];
        while(rightPtr<=right)
            temp[k++]=arr[rightPtr++];
        for (int i = 0; i < temp.length; i++) {
            arr[left+i]=temp[i];//left需要提前保存
        }
    }
}
