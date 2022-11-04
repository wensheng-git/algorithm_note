package doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :zhangwensheng
 * @date : 2022/10/30  0030 13:34
 *
 * 题目:
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * TODO:考虑用两数/四数相加的思想,不过要去重
 *      单一数组:排序后可以考虑DoublePointer是一个很好的方法
 */
public class TreeNumSum_DoublePointer {
    public List<List<Integer>> threeSum(int[] nums) {
        // 对于一个数组:双指针是一个好方法
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        // 三个指针锁定三个值,只要保证指针移动前后,它指的值不会重复就可以了
        for(int i=0;i<nums.length;i++){
            // i的去重
            if(i>0&&nums[i]==nums[i-1]) continue;
            int left=i+1;
            int right=nums.length-1;
            while(right>left){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum>0) right--;
                else if(sum<0) left++;
                else{ // 收集
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    // left的去重
                    while(right>left&&nums[left]==nums[left+1]) left++;
                    // right的去重
                    while(right>left&&nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
