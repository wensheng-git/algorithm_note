package heap;

/**
 * @author :zhangwensheng
 * @date : 2022/10/23  0023 16:37
 */
public class Heap {
    int[] heap;
    int limit;
    int heapSize;
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public Heap(){
        heap=new int[limit];
    }
    public boolean isEmpty(){
        return heapSize==0;
    }
    public boolean isFull(){
        return heapSize==limit;
    }
    public void heapInsert(int index){
        // 它去和祖宗比较
        while(heap[index]>heap[(index-1)/2]){//到达根后，父亲和自己是同一个人
            swap(heap,index,(index-1)/2);
            index=(index-1)/2;
        }
    }
    //从顶和子辈比较
    public void heapify(int index){
        int left=index*2+1;
        while(left<heapSize){
            // 和兄弟对决
            int largest=left+1<heapSize&&heap[left]>heap[left+1]?left:left+1;
            // 和父亲对决
            largest=heap[largest]>heap[index]?largest:index;
            if (largest==index) return;
            swap(heap,largest,index);
            index=largest;
            left=index*2+1;
        }
    }

    public void push(int value){
        if (heapSize==limit) new RuntimeException("heap is full");
        heap[heapSize]=value;
        heapInsert(heapSize++);
    }
    public int pop(){// 永远从根去弹出，弹了后要进行堆化--heapify(永远和根去堆化)
        int result=heap[0];
        swap(heap,0,--heapSize);
        heapify(0);
        return result;
    }



}
