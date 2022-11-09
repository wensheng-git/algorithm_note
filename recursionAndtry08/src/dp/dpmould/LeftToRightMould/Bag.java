package dp.dpmould.LeftToRightMould;

/**
 * @author :zhangwensheng
 * @date : 2022/11/4  0004 18:50
 *
 * w[]数组记录货物重量
 * v[]数组记录货物的价值
 * w和v对应
 * bag是可容纳的重量
 * 求bag的最大值
 *
 *
 *TODO:
 * 尝试:
 * 遍历w数组,要和不要,取max
 * base case:
 * index==arr.length return 0;
 * bag<0 返回-1  (上游作判断,无效解)
 *
 *
 *
 */
public class Bag {

    public static int process(int[] w,int[] v,int bag,int index){
        if (bag<0) return -1;
        if (index==w.length) return 0;
        //不要
        int process1 = process(w, v, bag, index + 1);
        //要
        int next = process(w, v, bag - w[index], index + 1);
        int process2=0;
        if (next!=-1){
            process2=v[index]+next;
        }
        return Math.max(process1,process2);
    }

    //index:0~N
    //reset:0~bag
    //dp[N+1][bag+1]
    //这里的dp定义是从[index,w.length-1]可以收集最大的价值
    public static int process_dp(int[] w,int[] v,int bag,int index){
        int[][] dp=new int[w.length+1][bag+1];
        //base case:
        for(int i=0;i<bag+1;i++){
            dp[w.length][i]=0;//没有位置可以走的时候,有再多剩余空间...最后一行都填完了
        }

        //填表...要和不要都是会process(index+1,reset-w[index])
        //依赖下一行,从下面的一行一行往上填
        for (int i=w.length-1;i>=0;i--){
            for (int j=0;j<=bag;j++){
                //要和不要取最大值:i和就都是有意义的,根据宏观的现实意义去写转移方程
                int p1=dp[i+1][j];
                int next=j-w[i]<0?-1:dp[i+1][j-w[i]];//存在无效尝试
                int p2=next==-1?0:v[i]+dp[i+1][j-w[i]];
                dp[i][j]=Math.max(p1,p2);
            }
        }
        return dp[0][bag];
    }








    /*
    * dp的另一种定义:[0,index]收集的最大价值
    * 依赖: 要了index和不要index==>dp[index-1][bag-w[index]]+dp[index-1][bag]
    * base case:bag=0的时候,value都是0;
    * dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
    * dp[j]=Math.max(dp[j],dp[j-w[i]]+[i])...一维空间压缩后从右往左填(不然前面的会覆盖上一层的东西,,导致后面的元素依赖上层的时候,上层的东西已经不见了)
    * */

    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7, 3, 1, 7 };
        int[] values = { 5, 6, 3, 19, 12, 4, 2 };
        int bag = 15;
        System.out.println(process(weights, values, bag, 0));
        System.out.println(process_dp(weights, values, bag, 0));
    }
}
