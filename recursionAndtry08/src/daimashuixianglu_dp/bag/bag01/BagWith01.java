package daimashuixianglu_dp.bag.bag01;

/**
 * @author :zhangwensheng
 * @date : 2022/11/8  0008 22:40
 */
public class BagWith01 {
    /*
    * 01,背包问题:
    * w[i]
    * v[i]
    * 对应着i号货物的价值
    * 每个货物拿一次
    * bag容量的背包可以放入最大价值的东西
    *
    *
    * 依赖分析:
    * dp[i][j]:(0,i)位置上数组的背包任意取,背包可以最大装的value;
    * i表示数组的位置,j表示背包剩余的容量==>都是变量
    *
    * dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i])
    * base case
    * j==0;没有容量,全部是0;
    * i==0,bag>=weight的位置只能放一个weight[0],其他地方都是0
    * */
    public static int process_bag01(int[] w,int[] v, int bag){
        int[][] dp = new int[w.length][bag+1];
        //第一列,bag为0,数组默认初始化为0
        for (int j=w[0];j<=bag; j++){
            dp[0][j]=v[0];
        }
        //画表知道一行一行往下填
        for (int i=1; i<w.length; i++){
            for (int j=0; j<=bag; j++){
                if (j-w[i]>=0){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[w.length-1][bag];
    }

    public static int process_bag01_spaceCompress(int[] w,int[] v, int bag){
        int[] dp = new int[bag+1];
        //第一列,bag为0,数组默认初始化为0
        //i==0的时,j只有大于等于了v[0]的位置才是v[0]
        for (int j=w[0];j<=bag; j++){
            dp[0]=0;
            dp[j]=v[0];
        }
        //画表知道一行一行往下填
        for (int i=1; i<w.length; i++){
            for (int j=bag; j>=0; j--){
                if (j-w[i]>=0){
                    dp[j]=Math.max(dp[j],dp[j-w[i]]+v[i]);//上格位置和上格位置-w[i]的位置和他pk
                }else{
                    dp[j]=dp[j];//上哥位置
                }
            }
        }
        return dp[bag];
    }



}
