package doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :zhangwensheng
 * @date : 2022/10/30  0030 14:02
 */
public class FourNumSum_DoublePointer {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 从三数之和去推广
        // 三数之和是固定了一个i,然后left和right去移动,
        // 四数之和就固定i+j 然后left和right去移动
        // 五数六数继续这样去推演
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length;j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue; // 这里j一定大于i+1,不能是1
                int left=j+1;
                int right=nums.length-1;
                while(right>left){
                    long sum=(long)nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum>target) right--;
                    else if(sum<target) left++;
                    else{
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right&&nums[left]==nums[left+1]) left++;
                        while(left<right&&nums[right]==nums[right-1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
