package daimashuixianglu_dp.bag.bag01;

/**
 * @author :zhangwensheng
 * @date : 2022/11/8  0008 23:50
 */
public class CanPartitionArrayWithBag01 {
    public boolean canPartition(int[] nums) {
        //简单理解:sum/2的背包,价值是num[i]的累加,如果装满了,证明就是有num[i]的累加是等于sum/2的
        int sum=0;
        for (int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        if(sum%2==1) return false;//奇数是不可能平均分配为整数的
        int[] dp = new int[sum/2+1];
        //初始化第一行
        for (int j=nums[0]; j<=sum/2; j++){
            dp[j]=nums[0];
        }
        //一行一行往下填
        for (int i=1; i<nums.length; i++){
            for (int j=sum/2; j>=0; j--){
                if(j-nums[i]>=0){
                    dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
                }else dp[j]=dp[j];//只能依赖上格
            }
        }
        //装满没有
        return dp[sum/2]==sum/2;
    }
}
