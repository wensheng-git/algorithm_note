package dp.dpmould.arrangeMould;

/**
 * @author :zhangwensheng
 * @date : 2022/11/6  0006 22:53
 *
 * TODO：范围尝试喜欢讨论开头和结尾，一步一步缩小范围到base case
 *
 * tip:该题目可以把str逆序，得到str2，str1和str2的最长公共子序列就是str1的最长回文子序列
 */
public class MaxPalindromeSubSequence {
    // str (i,j)的最长回文子序列
    // 暴力
    public static int process(char[] str,int left, int right){
        if(left==right) return 1;
        //尝试：普通情况
        //最长回文子序列和left无关，right有关==》【left+1,right】
        //最长回文子序列和right无关，left有关==》【left,right-1】
        //最长回文子序列和left和right都有关：str[left]==str[right]【left-1，right-1】+2
        int p1 = process(str,left+1,right);//和left无关
        int p2 = process(str,left,right-1);//和right无关
        int p3 = str[left]==str[right]?process(str,left+1,right-1)+2 :0;//和left和right有关
        return Math.max(Math.max(p1,p2),p3);//取max
    }


    public static int process_dp(char[] str,int left, int right){
       int[][] dp = new int[str.length][str.length];
       //填base case表：left==right的base case;
        int i = str.length;
        while(i-->0) dp[i][i]=1;
       //填普通情况：画表看出是斜着填
       //【left+1,right】下格 ；【left,right-1】左格；【left+1，right-1】下顶格
       for (int R=1; R<str.length; R++){//斜着填LR都是++
           int L=0;
           int RIndex=R;
           while(RIndex<str.length){
               dp[L][RIndex]=Math.max(Math.max(dp[L][RIndex-1],dp[L+1][RIndex]),str[L]==str[RIndex]?2+dp[L+1][RIndex-1]:0);
               L++;
               RIndex++;
           }
       }
       return dp[left][right];
    }

    public static void main(String[] args) {
        String s="987654678";
        System.out.println(process(s.toCharArray(), 0, s.length() - 1));
        System.out.println(process_dp(s.toCharArray(), 0, s.length() - 1));
    }


}
