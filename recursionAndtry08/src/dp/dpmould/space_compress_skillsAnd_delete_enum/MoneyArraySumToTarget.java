package dp.dpmould.space_compress_skillsAnd_delete_enum;

/**
 * @author :zhangwensheng
 * @date : 2022/11/7  0007 22:22
 */
public class MoneyArraySumToTarget {
    /*
    * 给定一个数组,数组里面存放着面额为数组值的元素,一个数组代表一张货币
    * 数组没有重复值,但是数组中的元素可以无限次使用
    * 问,从array中挑选几个货币,可以使得这些货币的值的之和为target,
    * 这种挑选有几种
    *
    *
    * 本质:组合可以重复是使用的,数组数字会等于target
    * */
    public static int process_bao1(int[] arr,int index, int rest){
        if(rest<0) return 0;
        if(rest==0) return 1;
        if(index==arr.length) return 0;
        //yao + bu yao
       return process_bao1(arr,index,rest-arr[index])+process_bao1(arr,index+1,rest);
    }
    public static int process_dp(int[] arr, int index,int rest){
        int[][] dp = new int[arr.length+1][rest+1];
        for(int i=0; i<=arr.length; i++) dp[0][i]=1;
        for(int i=0; i<=rest; i++) dp[i][arr.length]=0;
        //依赖右格子+上格(rest-arr[index]不越界的情况)
        for (int i=1; i<=rest; i++){
            for (int j=arr.length-1; j>=0; j--){
                dp[i][j]=dp[i][j+1]+((i-arr[j])>=0?dp[i-arr[j]][j]:0);
            }
        }
        return dp[rest][0];
    }



    //上面这种尝试是非常好的,依赖的关系没有枚举行为
    //所谓的枚举for里存在process(....),会导致一个格子计算会for循环起来依赖很多格子
    //TODO:消除枚举行为:通过建立的二维表建立的空间感:把for枚举的东西替代为临近格子 的东西
    //记忆化搜索不能消除枚举西行为,它没有对依赖的分析
    //TODO:严格的dp依赖优势;消除枚举行为+空间压缩
    /*
    * 下面这种尝试是会:for模板(对于动态规划的组合,子序列,子集合问题,都尽量使用非for模板,这样转化的暴力递归不会枚举行为)
    * */

    public static int process_bao2(int[] arr,int index,int rest){
        if (rest<0) return 0;
        if (rest==0) return 1;
        int ways=0;
        for (int i=index;i<arr.length;i++){
            //这里的i是为了有重复的时候,如果不需要重复,调用下一层的时候,它的i可以++,可以推动第二层
            ways+=process_bao1(arr,i,rest-arr[i]);//这里的ways需要用+,每层都会有一个ways
        }
        return ways;
    }
    public static int process_dp2(int[] arr,int index,int rest){
        int[][] dp = new int[rest+1][arr.length];
        for (int i=0; i<arr.length; i++){
            dp[0][i]=1;
        }
        for (int res=1; res<=rest; res++){
            for (int j=0; j<arr.length; j++){
//
//                int ways=0;
//                for (int i=j;i<arr.length;i++){
//                    //这里的i是为了有重复的时候,如果不需要重复,调用下一层的时候,它的i可以++,可以推动第二层
//                    //ways+=process_bao1(arr,i,rest-arr[i]);//这里的ways需要用+,每层都会有一个ways
//                    ways+=(res-arr[i]>=0)?dp[res-arr[i]][j]:0;
//                    dp[res][j]=ways;
//                }
//====================================>这里有枚举,可以用旁边的点来代替,但是这里代码有问题,没有写好,对数器不对
                dp[res][j]=res-arr[j]>=0?2*dp[res-arr[j]][j]:0;
            }
        }
        return dp[rest][0];
    }





    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        System.out.println(process_bao1(arr, 0, 4));
        System.out.println(process_dp(arr, 0, 4));
        System.out.println("==============================");
        System.out.println(process_bao2(arr,0,4));
        System.out.println(process_dp2(arr, 0, 4));
    }
}
