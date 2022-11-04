package binarySearch;

/**
 * @author :zhangwensheng
 * @date : 2022/10/27  0027 16:40
 */
/*
* 题目:
* 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
* */
public class binarySearch02 {
    public static int binarySearch02(int[] nums,int target){
        int left=0;
        int right= nums.length-1;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if (nums[mid]==target) return mid;
            if (nums[mid]<target) left=mid+1;
            if (nums[mid]>target) right=mid-1;
        }
        return right+1; //不管是mid的左边还是右边,最后的结果都是在right+1
    }
}
