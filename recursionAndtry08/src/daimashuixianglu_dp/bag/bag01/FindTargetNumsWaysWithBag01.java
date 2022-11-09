package daimashuixianglu_dp.bag.bag01;

/**
 * @author :zhangwensheng
 * @date : 2022/11/9  0009 9:59
 *
 * TODO:01背包问题的应用变化：找到累加和某个数值的时候
 */
public class FindTargetNumsWaysWithBag01 {
    public int findTargetSumWays(int[] nums, int target) {
        //left-right=target
        //left-(sum-left)=target
        //left=(sum+target)/2;
        //数组中找到累加和为target的组合有多少种
        //也可以转化为背包问题，背包是的bag是left。。装满背包的方法有几种
        int sum=0;
        for (int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        int bag = (sum+target)/2;
        if(bag<0) bag=-bag;
        if((sum+target)%2==1) return 0;//背包的容量是非整数
        int[]  dp = new int[bag+1];
        //不用在初始化第一行，在下面的for可填
        dp[0]=1;
        //模拟dp二维表
        for (int i=0; i<nums.length; i++){
            for (int j=bag; j>=0; j--){
                //要nums[i]+不要nums[i]的装法
                if(j-nums[i]>=0) dp[j]+=dp[j-nums[i]];
                else dp[j]=dp[j];
            }
        }
        return dp[bag];
    }
}
