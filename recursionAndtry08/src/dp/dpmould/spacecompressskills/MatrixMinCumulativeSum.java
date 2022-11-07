package dp.dpmould.spacecompressskills;

/**
 * @author :zhangwensheng
 * @date : 2022/11/7  0007 15:18
 * TODO:自定义给定的点去逼近固定的点就是base case
 *
 */
public class MatrixMinCumulativeSum {
    /*
     * 一个二维数组,从(0,0)开始出发,到(N-1,N-1)路劲最小的累加和
     * 只能向下和向右边左
     *
     * 尝试1:给一个终点,固定一个起点
     * 终点不断逼近起点:上一步要么是向下左或者向右走的
     * base case:终点为(0,0)的时候就是本身
     * 终点和(0,0)一行:matrix[i][j]+dp[0][j-1]
     * 终点和(0,0)一列:matrix[i][j]+dp[i-1][0]
     * 其他情况:依赖左/上格的最小值+本坐标
     * */

    public int  process_bao1(int[][] matrix, int x,int y){
        if (x==0&&y==0) return matrix[0][0];
        if (x==0&&y!=0){
            return matrix[x][y]+process_bao1(matrix,0,y-1);
        }
        if (y==0&&x!=0){
            return matrix[x][y]+process_bao1(matrix,x-1,y);
        }
        return matrix[x][y]+Math.min(process_bao1(matrix,x,y-1),process_bao1(matrix,x-1,y));
    }
    public int process_dp1(int[][] matrix, int x, int y) {
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 1; i <= y; i++) {
            dp[0][i] += dp[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i <= x; i++) {
            dp[i][0]=dp[i-1][0]+matrix[i][0];
        }
        //普通情况:依赖上格和左格,可以一列一列填填
        for (int i=1; i<=x; i++){
            for (int j=1;j<=y; j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+matrix[i][j];
            }
        }
        return dp[x][y];
    }




    /*
    * 尝试2:给定一个起点,固定终点,起点不断逼近终点到达base case,要么向右走,要么向左走
    * */
    public int process_bao2(int[][] matrix, int x, int y){
        //走了下一步才加本坐标
        if (x== matrix.length-1&&y== matrix.length-1) return matrix[matrix.length-1][matrix.length-1];
        //最后一行只能向左走,最后一列只能向右走,其他可以向左右走
        if (x==matrix.length-1&&y!= matrix.length-1){
            return matrix[x][y]+ process_bao2(matrix,x,y+1);
        }
        if (x!=matrix.length-1&&y==matrix.length-1){
            return matrix[x][y]+ process_bao2(matrix,x+1,y);
        }
        return matrix[x][y]+Math.min(process_bao2(matrix,x+1,y), process_bao2(matrix,x,y+1));
    }
    public int process_dp2(int[][] matrix, int x,int y){
        int N= matrix.length-1;
        int[][] dp = new int[matrix.length][matrix.length];
        // base case:
        dp[N][N]=matrix[N][N];
        //最后一行依赖左格
        //最后一列依赖上格
        for (int i=N-1; i>=0; i--){
            dp[i][N]=matrix[i][N]+dp[i+1][N];//最后一列
            dp[N][i]=matrix[N][i]+dp[N][i+1];//最后一行
        }
        //普通格子依赖左格和上格的最下值
        //倒着填:倒数第二行倒着填,向上推
        for (int i=N-1;i>=0; i--){
            for (int j=N-1; j>=0; j--){
                dp[i][j]=matrix[i][j]+Math.min(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
    }




}
