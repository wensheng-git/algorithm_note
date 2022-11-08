package daimashuixianglu_dp;

/**
 * @author :zhangwensheng
 * @date : 2022/11/8  0008 14:23
 */
public class RebootMoveWithObstacles {
    /*
    * 多了个障碍物:上一步逼近目的的时候本来有两条路,但是如果上一步是obstacle,那么上一步就是0;
    *
    * */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1||obstacleGrid[0][0]==1) return 0;
        return process(obstacleGrid,obstacleGrid.length-1,obstacleGrid[0].length-1);
    }
    public int process(int [][] obstacleGrid,int x,int y){//纵是m==>x,横是n==>y
        // 暴力
        // if(x==0&&y==0) return 1;
        // if(x==0&&y!=0){
        //      if(obstacleGrid[x][y-1]!=1)
        //      return process(obstacleGrid,x,y-1);//上一步只能是向右走
        //      else return 0;
        // }
        // if(x!=0&&y==0){
        //      if (obstacleGrid[x-1][y]!=1)
        //      return process(obstacleGrid,x-1,y);//上一步只能是向下走
        //      else return 0;
        // }
        // int p1=0;
        // if(obstacleGrid[x][y-1]!=1)
        // p1=process(obstacleGrid,x,y-1);
        // int p2=0;
        // if(obstacleGrid[x-1][y]!=1)
        // p2=process(obstacleGrid,x-1,y);
        // return p1+p2;

        int[][] dp = new int[x+1][y+1];
        dp[0][0]=1;
        for (int i=1 ;i<=y; i++){
            dp[0][i]=obstacleGrid[0][i-1]==0?dp[0][i-1]:0;
        }
        for (int i=1; i<=x; i++){
            dp[i][0]=obstacleGrid[i-1][0]==0?dp[i-1][0]:0;
        }

        for (int row=1; row<=x; row++){
            for (int col=1; col<=y; col++){
                int p1=0;
                if(obstacleGrid[row][col-1]!=1)//尚步向右走
                    p1=dp[row][col-1];
                int p2=0;
                if(obstacleGrid[row-1][col]!=1)//上步向下走
                    p2=dp[row-1][col];
                dp[row][col]=p1+p2;
            }
        }
        return dp[x][y];
    }
}
