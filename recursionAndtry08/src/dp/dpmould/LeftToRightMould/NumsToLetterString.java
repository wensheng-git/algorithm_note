package dp.dpmould.LeftToRightMould;

/**
 * @author :zhangwensheng
 * @date : 2022/11/4  0004 20:27
 * 规定1->A,2->B.....27->Z
 * 给定一串数字111,返回可以转化多少种字符串.如AK,AAA,KA
 * <p>
 * TODO:
 * str[i]-'0'=1代表i就是'1'字符
 * 所以只要只要是'数字'-0 < 27都是可以有效转换的...因为1~26都是可以有效转化为26个字母
 * <p>
 * TODO:尝试:从左往右试试一个字符可以转化,再试试两个字符能不能转化,,结果相加
 * 当最后index==length了证明,全部转化完了有效
 */
public class NumsToLetterString {
    public static int process(char[] str, int index) {
        if (index == str.length) return 1;
        if (str[index] == '0') return 0;//无效转化,前面不能这样转化
        //单个双个转化尝试
        int ways = process(str, index + 1);//一个字符肯定可以转
        if (index + 1 < str.length && ((str[index] - '0') * 10 + str[index + 1] - '0') < 27) {
            ways += process(str, index + 2);
        }
        return ways;
    }




    //遍历字符串单个转化或者两个转化,遍历完了就是一种结果,index为变量,一维数组
    public static int process_dp(char[] str,int index){
        int[] dp = new int[str.length+1];
        dp[str.length]=1;
        for(int i=str.length-1;i>=0;i--){
         dp[i]=dp[i+1];
            if (i + 1 < str.length && ((str[i]-'0')*10+str[i+1]-'0')< 27) {
                dp[i]=dp[i+1]+dp[i+2];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String s="1111222221123433121222121111212111";
        char[] chars = s.toCharArray();
        System.out.println(process(chars, 0));
        System.out.println(process_dp(chars, 0));
    }

}
