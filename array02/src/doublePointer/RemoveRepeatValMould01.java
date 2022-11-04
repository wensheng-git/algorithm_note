package doublePointer;

/**
 * @author :zhangwensheng
 * @date : 2022/10/28  0028 10:12
 */
/*
* 题目
* 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
* TODO:在数组和链表的操作中是非常常见的，很多考察数组、链表、字符串等操作的面试题，都使用双指针法。
*
* TODO:双指针要求数组有序的时候,可以先排序
* 快慢指针
* 双向指针:可能破坏有序稳定性
* */
public class RemoveRepeatValMould01 {
    // 快慢指针
    public int removeElement(int[] nums, int val) {
        int k=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]==val)
                continue;
            nums[k++]=nums[i];
        }
        return k;
    }

    // 左右指针相互靠近,到left摸到了right
    // 双向指针:左右遇某个条件挺下来交换或者其他操作
    public int removeElement2(int[] nums,int val){
        int left=0;
        int right=nums.length-1;
        // 找到不等于的
        while(right>=0&&nums[right]==val) right--;
        while(left<=right){
            if(nums[left]==val){
                nums[left]=nums[right];
                right--;
            }
            left++;
            while(right>=0&&nums[right]==val) right--;
        }
        return left;
    }
}
