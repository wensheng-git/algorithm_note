package binarySearch;

/**
 * @author :zhangwensheng
 * @date : 2022/10/27  0027 17:02
 */
/*
* 题目:
* 给定一个按照升序排列的整数数组重复nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
* */
public class binarySearch03 {
    public static int[] search(int[] nums,int target,int left,int right){
        int[] result={-1,-1};
        int mid=left+((right-left)>>1);
        while(left<=right){
            if (nums[mid]==target){
                result[0]=mid;
                result[1]=mid;
                int i=1;
                // 左扩
                while(mid-i>=0&&nums[mid]==mid-i){
                    result[0]=mid-i;
                    i++;
                }
                int k=1;
                // 右扩
                while(mid+i<=nums.length-1&&nums[mid+i]==mid+k){
                    result[1]=mid+k;
                    k++;
                }
                return result;
            }
            if (nums[mid]>target) right=mid-1;
            if (nums[mid]<target) left=mid+1;
        }
        return result;
    }
}
