package dp.dpmould.arrangeMould;

/**
 * @author :zhangwensheng
 * @date : 2022/11/4  0004 13:47
 * <p>
 * 一组棋牌,在一个arr中排列,数值代表棋牌大小
 * 两个人一起拿,只能从arr的L或R拿
 * 两个人绝顶聪明A先拿,B后拿
 * 判断谁获胜
 */
public class ChessChartArrayMaxWin {
    /*
     * 宏观逻辑
     * 每次那可能是两种身份:先手,后手
     * 先手拿了L/R中最大值的情况,后手拿了该数组最小的情况
     * L==R,先手拿了最后一个,后手拿了0
     * */
    //暴力递归
    public static int pre(int[] arr, int left, int right) {
        if (left == right) return arr[left];
        return Math.max(arr[left] + post(arr, left + 1, right), arr[right] + post(arr, left, right - 1));
    }

    public static int post(int[] arr, int left, int right) {
        if (left == right) return 0;
        //**********核心:我后面拿,先手可能拿了左边的,也可能拿了右边的,它拿了后,我作为先手去拿,我不知道先手拿了左边的还是右边的
        //在我作为先手面对的两种数组的情况下,我肯定是面临差一点的数组,因为之前的先手绝顶聪明
        return Math.min(pre(arr, left + 1, right), pre(arr, left, right - 1));
    }





    //记忆化搜索
    public static int pre_cache(int[] arr, int left, int right, int[][] preMap, int[][] postMap) {
        if (preMap[left][right] != -1) return preMap[left][right];
        int ans = 0;
        if (left == right) ans = arr[left];
        ans = Math.max(arr[left] + post_cache(arr, left + 1, right, preMap, postMap), arr[right] + post_cache(arr, left, right - 1, preMap, postMap));
        preMap[left][right] = ans;
        return ans;
    }



    public static int post_cache(int[] arr, int left, int right, int[][] preMap, int[][] postMap) {
        if (postMap[left][right] != -1) return postMap[left][right];
        int ans = 0;
        if (left == right) ans = 0;
        //我作为了后面拿的,肯定是拿到最小的,这才是符合两个人都是绝顶聪明的
        ans = Math.min(arr[left] + pre_cache(arr, left + 1, right, preMap, postMap), arr[right] + pre_cache(arr, left, right - 1, preMap, postMap));
        return ans;
    }







    //经典依赖dp
    public static String process_dp(int[] arr, int left, int right, int[][] preMap, int[][] postMap) {
        // base case;
        for (int i = 0; i < arr.length; i++) {
            preMap[i][i] = arr[i];
            postMap[i][i] = 0;
        }
        //尝试,,先手拿了一个作为后手去拿(左右去最大值);后手拿了一个后作为先手拿(最小的情况)(数组只发生一次改变表示先手拿了)
        for (int i = 1; i < arr.length; i++) {
            //斜着填:一个起始位置,一直++
            int L = 0;
            int R = i;
            while (R < arr.length) {//行是会越界的...arr[本身]看是拿了左边的还是右边的
                preMap[L][R] = Math.max(arr[L] + postMap[L + 1][R], arr[R] + postMap[L][R - 1]);
                postMap[L][R] = Math.min(preMap[L + 1][R], preMap[L][R - 1]);
                L++;
                R++;
            }
        }
        return preMap[0][right] > postMap[0][right] ? new String("先手赢了") : new String("后手赢了");
    }







    //for test
    public static String win1(int[] arr) {
        int first = f1(arr, 0, arr.length - 1);
        int second = g1(arr, 0, arr.length - 1);
        return first>second?"先手赢了":"后手赢了";
    }

    // arr[L..R]，先手获得的最好分数返回
    public static int f1(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int p1 = arr[L] + g1(arr, L + 1, R);
        int p2 = arr[R] + g1(arr, L, R - 1);
        return Math.max(p1, p2);
    }

    // // arr[L..R]，后手获得的最好分数返回
    public static int g1(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int p1 = f1(arr, L + 1, R); // 对手拿走了L位置的数
        int p2 = f1(arr, L, R - 1); // 对手拿走了R位置的数
        return Math.min(p1, p2);
    }

    public static void main(String[] args) {
        int[] arr = {0, 35, 11, 61, 41, 14, 64, 13, 35, 22, 46, 35};
        //        int A=pre(arr,0,arr.length-1);
        //        int B=post(arr,0, arr.length-1);
        //        String s=A>B?"先手获胜":"后手获胜";
        //        System.out.println(s);
        //        System.out.println("=============================");
        int[][] preMap = new int[arr.length][arr.length];
        int[][] postMap = new int[arr.length][arr.length];
        //        String s2=
        //                pre_cache(arr,0,arr.length-1,preMap,postMap)==post_cache(arr,0,arr.length-1,preMap,postMap)
        //                ?"先手获胜":"后手获胜";
        //        System.out.println(s2);

        System.out.println(process_dp(arr, 0, arr.length - 1, preMap, postMap));
        //System.out.println(win1(arr));

    }
}
