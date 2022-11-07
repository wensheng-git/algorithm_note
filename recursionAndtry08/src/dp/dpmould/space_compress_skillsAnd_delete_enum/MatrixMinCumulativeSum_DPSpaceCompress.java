package dp.dpmould.space_compress_skillsAnd_delete_enum;

/**
 * @author :zhangwensheng
 * @date : 2022/11/7  0007 17:53
 */
public class MatrixMinCumulativeSum_DPSpaceCompress {
    /*
    * 通过画表,发现,一个格子只依赖左和上
    * 对于一个格子:dp表中有用的只有两行
    * 用两个数组去====>代替dp表
    * 我们在脑海中模拟出dp表===>也按照dp表填的方式去一行一行的填
    *
    * 我们用一个数组保留了上一行的结果
    * 用另一个数组去填本行:
    * 本行结束,本行作为上一行,去填下一行(用保留上上行的数组[因为它已经没有用了])
    *
    *
    * 更细粒度优化
    * 使用一个数组
    * 数组本身保留了上一行信息
    * 填本行的时候,数组的index保留的就是上格的信息.index-1保留的就是左格的信息
    * TODO:这就是最优解:时间和空间的到达完美
    * PS:填表的for循环还是要模拟一张dp表,所以时间上没有优化,它只是压缩了空间
    * */

    public static int process(int[][] matrix,int x, int y){
        int[] arr= new int[y+1];
        //初始化第一行
        for (int i=1; i<y+1;i++){
            arr[0]=matrix[0][0];
            arr[i]=matrix[0][i]+arr[i-1];
        }
        //一行一行往下填
        for (int i=1;i<=x; i++){
            for (int j=1; j<=y; j++){
                arr[0]=matrix[i][0]+arr[0];//只是依赖上格
                arr[j]=Math.min(arr[j-1],arr[j])+matrix[i][j];//娶min
            }
        }
        //娶终点
        return arr[y];
    }

    //for test
    public static int  process_bao1(int[][] matrix, int x,int y){
        if (x==0&&y==0) return matrix[0][0];
        if (x==0&&y!=0){
            return matrix[x][y]+process_bao1(matrix,0,y-1);
        }
        if (y==0&&x!=0){
            return matrix[x][y]+process_bao1(matrix,x-1,y);
        }
        return matrix[x][y]+Math.min(process_bao1(matrix,x,y-1),process_bao1(matrix,x-1,y));
    }

    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4,5},{2,1,3,4,2},{17,4,2,5,7},{13,32,1,31,1}};
        System.out.println(process_bao1(matrix, 3, 4));
        System.out.println(process(matrix, 3, 4));
    }
}
