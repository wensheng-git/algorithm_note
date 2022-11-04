package doublePointer;

/**
 * @author :zhangwensheng
 * @date : 2022/10/28  0028 12:04
 */

/*
* 题目:
* 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
*
* TODO:稳定用快慢或者双向,左右比较一定用双向
* 最大值产生在左右两边=========>双向指针(一般和merge时候的指针比较类似left和right和i三个指针)
 * */
public class SortArraySquare {
    public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++) nums[i]=nums[i]*nums[i];
        // 双向指针类似partition的过程
        int left=0;
        int right=nums.length-1;
        int i=nums.length-1;
        // 最大值就是left和right的决斗
        int[] result=new int[nums.length];
        while(left<=right){
            result[i--]=nums[left]>nums[right]?nums[left++]:nums[right--];
        }
        return result;
    }
}
