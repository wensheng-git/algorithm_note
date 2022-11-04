package dp.dpmould.arrangeMould;

/**
 * @author :zhangwensheng
 * @date : 2022/11/4  0004 12:17
 * 1~N的位置,机器人从一个start位置开始走,目标是aim位置,总共要走rest步
 *
 * dp思路
 * 宏观问题===>依赖顺序===>画表填表base case,再按照依赖顺序填
 */
public class MoveReboot {
    /*
    * cur==1;只能向右边走
    * cur==N;只能向左走
    * cur中间,左右都可以走
    * cur==aim,且rest==0;才返回1;否则返回0
    * */
    //暴力
    public static int process(int cur,int rest,int aim,int N){
        if (rest==0){
            return cur==aim?1:0;
        }
        if (cur==1){
            return process(2,rest-1,aim,N);
        }
        if (cur==N){
            return process(N-1,rest-1,aim,N);
        }
        return process(cur-1,rest-1,aim,N)+process(cur+1,rest-1,aim,N);
    }



    public static int way2(int cur,int rest,int aim,int N){
        int[][] dp=new int[cur+1][rest+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j]=-1;
            }
        }
        return process_dp_cache(cur,rest,aim,N,dp);
    }
    //已经是dp,是不关心位置依赖的dp....从顶向下的dp.....也叫记忆化搜索
    public static int process_dp_cache(int cur,int rest,int aim,int N,int[][] dp){
        if (dp[cur][rest]!=-1) return dp[cur][rest];
        int ans=0;
        if (rest==0){
            ans=cur==aim?1:0;
        }
        if (cur==1){
            ans=process(2,rest-1,aim,N);
        }
        if (cur==N){
            ans=process(N-1,rest-1,aim,N);
        }
        else ans=process(cur-1,rest-1,aim,N)+process(cur+1,rest-1,aim,N);
        //计算了一次就不用计算了
        dp[cur][rest]=ans;
        return ans;
    }


    //N表示1~N个位置
    //K表示需要走几步
    //aim表示目标位置
    public static int process_dp(int start,int K,int aim,int N){
        //绘制dp[start][rest]的表
        //根据暴力递归看出依赖关系
        //根据依赖关系去填表
        /*
        * 也可以根据宏观逻辑去填
        * start==aim,rest==0,dp[aim][0]=1;start!=aim,那么dp[start][0]=0
        * start=1,它只能向右边走,所以只是依赖start=2,rest=rest-1;===>dp[1][reset]=dp[2][reset-1]
        * start=N,它只能向左走,所以只能依赖start=N-1,rest=rest-1;===>dp[N][reset]=d[N-1][reset-1]
        * start==mid,它左右的可以走,所以依赖start=start+1/start-1;reset=reset-1==>dp[start][reset]=dp[start+1][reset-1]+dp[start-1][reset-1]
        * 怎么去填---画表?
        * 先填:base case的值
        * 根据依赖关系先填列再填行
        * */
        //cur,reset
        int[][] dp=new int[N+1][K+1];
        dp[aim][0]=1;//如果cur!=aim,已经默认是0....base case要联系实际意义
        //先列后行
        for (int reset = 1; reset < K + 1; reset++) {//剩余几步,0步在base case确定了
            for (int cur = 1; cur < N+1; cur++) {//没有0位置
                if(cur==1){
                    dp[cur][reset]=dp[cur+1][reset-1];
                }
                else if (cur==N){
                    dp[cur][reset]=dp[cur-1][reset-1];
                }
                else{
                    dp[cur][reset]=dp[cur+1][reset-1]+dp[cur-1][reset-1];
                }
            }
        }
        return dp[start][K];
    }


    public static void main(String[] args) {
        //暴力递归
        System.out.println(process(4, 6, 6, 8));
        //记忆化搜索
        System.out.println(way2(4, 6, 6, 8));
        //经典dp
        System.out.println(process_dp(4, 6, 6, 8));
    }

}


