package rmatrix;

/**
 * @author :zhangwensheng
 * @date : 2022/10/28  0028 15:56
 */
/*
* 题目:
* 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
  示例:
  输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
*
* 思路:
* coding的问题,给定起始位置,处理完一圈再递归调用内圈;
* */
public class RMatrix {
    public int[][] generateMatrix(int n) {
        // 一圈的每边:前闭后开区间
        int start=0;
        int i,j; // 当前的下标
        int offset=1;
        int[][] result=new int[n][n];
        int count=1;

        //开始遍历.n/2圈;
        int loop=1;
        while(loop<=n/2){
            for( j=start;j<n-offset;j++)  result[start][j]=count++;// 这里必须先用start,每圈都是不同的
            for( i=start;i<n-offset;i++) result[i][j]=count++;
            for(;j>start;j--) result[i][j]=count++;
            for(;i>start;i--) result[i][j]=count++;
            loop++;
            start++;
            offset++;
        }
        if(n%2==1) result[start][start]=count;
        return result;
    }
}
