package dp.dpmould.LeftToRightMould;

/**
 * @author :zhangwensheng
 * @date : 2022/11/4  0004 11:04
 */
public class FBArray {
    public static int func(int n){
        if (n==1) return 1;
        if (n==2) return 1;
        return func(n-1)+func(n-2);
    }

    public static int func_dp(int n){
        int[] dp=new int[n+1];
        if (n==1) dp[n]=1;
        if (n==2) dp[n]=1;
        for(int i=3;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
