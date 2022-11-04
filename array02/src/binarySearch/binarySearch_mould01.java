package binarySearch;

/**
 * @author :zhangwensheng
 * @date : 2022/10/27  0027 16:13
 */
/*
*
* 题目描述:
* 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
* */
public class binarySearch_mould01 {
    // Recursion version
    public static int search(int[] nums,int target){
        return binarySearch01(nums,target,0,nums.length-1);
    }
    public static int binarySearch01(int[] nums, int target, int left, int right){
        int mid=left+((right-left)>>1);
        if (nums[mid]==target) return mid;
        if (nums[mid]<target) return binarySearch01(nums,target,mid+1,right);
        if (nums[mid]>target) return binarySearch01(nums,target,left,mid-1);
        return -1; // 递归最后的条件可以写到不满足所有事情的返回值中;
    }

    // while version
    public static int binarySearch02(int[] nums,int target){
        int left=0;
        int right= nums.length-1;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if (nums[mid]==target) return mid;
            if (nums[mid]<target) left=mid+1;
            if (nums[mid]>target) right=mid-1;
        }
        return -1;
    }


}
