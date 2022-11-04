package moveWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :zhangwensheng
 * @date : 2022/10/28  0028 14:31
 */
/*
* 题目:
* 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
*
* 滑动窗口:双指针的第三种情况
* 类似快慢指针:
* 起始指针与终止指针
* 1:一个for循环代表终止指针
* 2:到达条件后不断去尝试调节起始指针
* 3:用一个容器或者变量记录1和2中间产生的东西
*
*
* PS:
* TODO: 滑动窗口使用于字串的问题
* 滑动窗口是O(n)的代价,每个元素进来一次,出去一次,2n的操作
* TODO:主要什么时机调动起始指针,还有怎么调,中间收集数据来抉择并且返回(最大窗口和最小窗口)
* TODO:最大窗口和最小窗口都可以在每次终止指针移动一次的时候来决定(当前窗口right-left+1)
* */
public class MinSubArrayLen_mould {
    // 连续字串小于target的最小窗口
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;//起始指针
        int result=Integer.MAX_VALUE;//最后没有变返回0
        int sum=0;
        for (int right=0; right<nums.length; right++){ //终止指针
            sum+=nums[right];
            // sum>=target了不断缩短起始位置去探测
            while(sum>=target){
                result=Math.min(result,right-left+1);
                sum-=nums[left++];
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }
}
