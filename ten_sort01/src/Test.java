import java.util.Arrays;

/**
 * @author :zhangwensheng
 * @date : 2022/10/25  0025 16:59
 */
/*
* 冒泡,插入:n^2且稳定
* 选择:n^2,不稳定=======================它会跳着交换
* shell:n^(1.3~2),不稳定
* merge:时间:nlogn,空间:n+logn[logn为递归开销],稳定
* quick:时间:nlogn,空间logn,不稳定
* 计数,基数:时间:n,空间:n+k,稳定==========有范围
* 堆排序:时间:nlogn,空间1================不稳定
*
*
*
*不稳定:选择,shell,快排,堆排
*
* */
public class Test {
    public static void main(String[] args) {
        int[] arr={3,5,1,56,4,41,4,6,452,3,2,236};
//        bubble(arr);
//        selection(arr);
//        insert(arr);
//        shell(arr);
//        mergeSort(arr,0,arr.length-1);
//        quickSort(arr,0, arr.length-1);
//        System.arraycopy(count(arr),0,arr,0,arr.length);
//        radix(arr);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void bubble(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]) swap(arr,j,j+1);
            }
        }
    }
    public static void selection(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos=i;
            for (int j=i+1;j<arr.length;j++){
                minPos=arr[minPos]<arr[j]?minPos:j;
            }
            swap(arr,minPos,i);
        }
    }
    public static void insert(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j=i;j>0;j--){
                if (arr[j]<arr[j-1]) swap(arr,j,j-1);
            }
        }
    }
    public static void shell(int[] arr){
        int h=1;
        while(h<arr.length/3){
            h=3*h+1;
        }
        for (int gap=h;gap>0;gap=(gap-1)/3){
            for (int i=gap;i<arr.length;i++){//从第二组开始,插入的时候-gap到达第一组
                for(int j=i;j>gap-1;j=j-gap){
                    if (arr[j]<arr[j-gap]) swap(arr,j,j-gap);
                 }
            }
        }
    }

    public static void mergeSort(int[] arr,int left,int right){
        if (left==right) return;
        int mid=left+(right-left)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid+1,right);
    }
    public static void merge(int[] arr,int leftPtr,int rightPtr,int rightBound){
        int[] temp=new int[rightBound-leftPtr+1];
        int k=0;
        int left=leftPtr;
        int mid=rightPtr-1;
        while(leftPtr<=mid&&rightPtr<=rightBound) temp[k++]=arr[leftPtr]<=arr[rightPtr]?arr[leftPtr++]:arr[rightPtr++];
        while(leftPtr<=mid) temp[k++]=arr[leftPtr++];
        while(rightPtr<=rightBound) temp[k++]=arr[rightPtr++];
        for (int i = 0; i < temp.length; i++) {
            arr[left+i]=temp[i];
        }
    }

    public static void quickSort(int[] arr,int left,int right){
        if (left>=right) return;
        swap(arr,left+(int)(Math.random()*(right-left+1)),right);
        int[] equalArea=partition(arr,left,right);
        quickSort(arr,left,equalArea[0]-1);
        quickSort(arr,equalArea[1]+1,right);
    }
    public static int[] partition(int[] arr,int left,int right){
        int leftPtr=-1;
        int rightPtr=right;
        int pivot=arr[right];
        int i=0;
        while(i<rightPtr){
            if (arr[i]==pivot) i++;
            else if(arr[i]<pivot) swap(arr,++leftPtr,i++);
            else swap(arr,--rightPtr,i);
        }
        swap(arr,i,right);
        return new int[]{leftPtr+1,i};
    }
    public static int[] count(int[] arr){
        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            max=max>arr[i]?max:arr[i];
        }
        int[] bucket=new int[max+1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        for (int i = 1; i < bucket.length; i++) {
            bucket[i]=bucket[i]+bucket[i-1];
        }
        int[] result=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            result[--bucket[arr[i]]]=arr[i];
        }
        return result;
    }

    public static int getBit(int i){
        int result=0;
        while(i!=0) {
            result++;
            i=i/10;
        }
        return result;
    }
    public static void radix(int[] arr){
        int maxBit=0;
        for (int i = 0; i < arr.length; i++) {
            maxBit=getBit(arr[i])>maxBit?getBit(arr[i]):maxBit;
        }

        for (int i = 0; i < maxBit; i++) {
            int[] bucket=new int[10];
            int division=(int)Math.pow(10,i);

            for (int j = 0; j < arr.length; j++) {
                int num=arr[j]/division%10;
                bucket[num]++;
            }
            for (int j = 1; j < bucket.length; j++) {
                bucket[j]+=bucket[j-1];
            }

            int[] result=new int[arr.length];
            for(int j=arr.length-1;j>=0;j--){
                int num=arr[j]/division%10;
                result[--bucket[num]]=arr[j];
            }
            System.arraycopy(result,0,arr,0,arr.length);
        }
    }



    //堆排序
    public static void heapInsert(int[] arr,int index){
        while(arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;
        }
    }

    public static void heapIfy(int[] arr,int index,int heapSize){
        int left=index*2+1;
        while(left<heapSize){
            int largest=left+1<heapSize&&arr[left]<arr[left+1]?left+1:left;// 注意没有右孩子也是给左孩子
            largest=arr[largest]<arr[index]?index:largest;
            if (largest==index) return;
            swap(arr,largest,index);
            index=largest;
            left=index*2+1;
        }
    }
    public static void heapSort(int[] arr){
        // 堆化..全部都要化(O(n))
        for (int i=arr.length-1;i>=0;i--) heapIfy(arr,i,arr.length);

        // 排序..最后一个不用排序了nlogn
        int heapSize= arr.length;
        while(heapSize>1){
            swap(arr,0,--heapSize);
            heapIfy(arr,0,heapSize);
        }
    }
}
