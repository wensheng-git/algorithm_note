package daimashuixianglu_dp;

/**
 * @author :zhangwensheng
 * @date : 2022/11/8  0008 16:35
 */
public class NumsSBT {
    public int numTrees(int n) {
        //发现规律:
        //n时候.分别用1...n作为头结点,左右子树的数量加起来要是n-1
        //比如:左子树是1个元素,右子树就是n-2个元素..左子树可以是SBT的个数*右子树可以是SBT的个数,等于固定的那个为根节点的二叉树为SBT的个数(一次一次更换root,累加他们做头的SBT数量)

        int[] dp = new int[n+1];
        dp[0]=1;//一边的子树为0,有乘法,所以必须为1
        dp[1]=1;

        for (int i=2; i<=n; i++){//n个元素填表
            //i个元素依次遍历,分别作头的累加
            int sum=0;
            for (int j=1; j<=i; j++){//1~i都要做头
                //左子和右子为SBT相乘
                sum+=dp[j-1]*dp[i-j];
            }
            dp[i]=sum;
        }
        return dp[n];
    }
}
