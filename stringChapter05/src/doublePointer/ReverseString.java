package doublePointer;

import com.sun.org.apache.xpath.internal.operations.String;

/**
 * @author :zhangwensheng
 * @date : 2022/10/30  0030 16:04
 */
public class ReverseString {

    public void reverseString(char[] s) {
        // 涉及左右两边操作的东西,用双向指针
        int left=0;
        int right=s.length-1;
        while(left<right){
            swap(s,left++,right--);

        }

    }

    public void swap(char[] arr,int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


}
