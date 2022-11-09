package daimashuixianglu_dp.bag.bag01;

/**
 * @author :zhangwensheng
 * @date : 2022/11/9  0009 0:59
 */
public class LastStoneWeightWithBag01 {
    public int lastStoneWeightII(int[] stones) {
        //用stones累加和一半的背包，最多可以装多少的重量，它装的重量*2就是可以被粉碎的
        int sum=0;
        for (int i=0; i<stones.length; i++){
            sum+=stones[i];
        }
        int bag = sum/2;
        int[] dp = new int[bag+1];
        for(int i=stones[0]; i<=bag; i++){
            dp[i]=stones[0];
        }
        //头脑模拟化dp表（行是stones重量，列是bag）
        for (int i=1; i<stones.length; i++){
            for (int j=bag; j>=0; j--){//逆序填，一维数组模拟二维数组
                if(j-stones[i]>=0) dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
                else dp[j]=dp[j];//没要stones[i],因为，bag不够了
            }
        }
        return sum-dp[bag]-dp[bag];
    }
}
