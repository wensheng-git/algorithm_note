package dp.dpmould.samplemappingmould;

/**
 * @author :zhangwensheng
 * @date : 2022/11/6  0006 21:15
 */
public class MaxLenPublicSubSequence {
    /*
    * question:
    * 给定str1和str2，求出str1和str2的最长公共子序列
    * 样本对应模型：一个样本做行一个样本作列==二维表
    * TODO:样本对应模型一般以结尾去讨论可能性，样本长的时候，它是先计算短的样本推出长的样本的答案，这就是原因
    * */

    /*
    * 宏观尝试：str1[0,i] str2[0,j]
    * 1：最长的公共子序列一定不以i结尾，可能以j结尾
    * 2: 最长的公共子序列一定不以j结尾，可能以i结尾
    * 3：最长的公共子序列一定以i和j结尾：（str[i]==str[j]）
    * ps:1和2其实存在交集==》都不以i和j结尾，但是无所谓，求的公共子序列是客观唯一的
    * Math.max(1,2,3)------------------TODO：列出多种可能性是为了缩减问题的规模
    * base case:
    *  i==0&&j==0  最长公共子序列 = str[i]==str[j]?1:0
    *  i==0，j!=0, 最长公共子序列 = str[i]==str[j]?1:[str(i)和str(0,j-1)的最长公共子序列的答案]
    *  i！=0，j==0  和上一行类似
    *  i！=0&&j!=0...即最上面讨论的三种清空的最大。。。。。。本身是不断的缩小规模到达base case去返回
    * */
    public int process(char[] str1,char[] str2,int i, int j){
        if(i==0&&j==0) return str1[i]==str2[j]?1:0;
        else if (i==0&&j!=0) return str1[i]==str2[j]?1:process(str1,str2,i,j-1);
        else if (i!=0&&j==0) return str1[i]==str2[j]?1:process(str1,str2,i-1,j);
        else{
            int p1 = process(str1,str2,i,j-1);//一定不以j结尾
            int p2 = process(str1, str2,i-1,j);//一定不以i结尾
            int p3 = str1[i]==str2[j]?(1+process(str1,str2,i-1,j-1)):0;//一定以ij结尾，，，如果两个元素不等于，就是没有这种可能
            return Math.max(Math.max(p1,p2),p3);
        }
    }

    /*
    * 宏观思考：本质：缩短样本规模，
    * 样本对应模型从结尾去思考尝试的可能性，不断缩小规模
    * TODO：三种可能性；一定不以i，一定不以j，一定以i和j结尾==》max
    *  base case:
    *  填表：
    *  dp[i==0][j===0].dp[0][0]=str[i]==str[j]?1:0
    *  dp[i==0][j！=0] dp[0][j]=str[i]==str[j]?1:dp[0][j-1]
    *  dp[i!=0][j==0] dp[i][0]=str[i]==str[j]?1:dp[i-1][0]
    *  其他情况：依赖【上格，左格和对顶格】======》base case把0行0列都填满了，
    *  dp[i][j]==>三种情况的最大值dp[i-1][j],dp[i][j-1],dp[i-1][j-1]+1===>取max
    * */
    public int process(char[] str1,char[] str2){
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0]=str1[0]==str2[0]?1:0;
        for (int j = 1; j < str2.length; j++) { //填第一行
            dp[0][j]=str1[0]==str2[j]?1:dp[0][j-1];
        }
        for (int i = 1; i < str1.length; i++) { // 填第一列
            dp[i][0]=str1[i]==str2[0]?1:dp[i-1][0];
        }

        //其他情况取最值：三格的最大值,,,i代表str1的长度，j代表str2的长度
        for (int i=1; i<str1.length; i++){
            for (int j=1; j<str2.length; j++){
                dp[i][j]=Math.max(Math.max(dp[i][j-1],dp[i-1][j]),str1[i]==str2[j]?1+dp[i-1][j-1]:0);
            }
        }
        return dp[str1.length-1][str2.length-1];
    }
}
