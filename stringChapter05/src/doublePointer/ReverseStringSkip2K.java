package doublePointer;

/**
 * @author :zhangwensheng
 * @date : 2022/10/30  0030 16:50
 */
public class ReverseStringSkip2K {
    // left和right的加减问题只要抓住一个标准(right-left+1)是数组的长度,,left和right都为有意义的下标
    public String reverseStr(String s, int k) {
        char[] chars=s.toCharArray();
        if(chars.length==1) return new String(chars);
        for (int i=0;i<s.length();i=i+2*k){
            int left=0;
            int right=0;
            // 反转不足k的
            if(chars.length-i<k){
                left=i;
                right=chars.length-1;
                while(left<right){
                    swap(chars,left++,right--);
                }
            }
            // 反转不足2k的
            else if( chars.length-i>=k  &&  chars.length-i<2*k ){
                left=i;
                right=left+k-1;
                while(left<right){
                    swap(chars,left++,right--);
                }
            }
            else{
                // 正常情况
                left=i;
                right=left+k-1;
                while(left<right){
                    swap(chars,left++,right--);
                }
            }
        }
        return new String(chars);
    }
    public void swap(char[] arr,int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
