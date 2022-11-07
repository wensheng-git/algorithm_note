package dp.dpmould.businessrestrictMould;

/**
 * @author :zhangwensheng
 * @date : 2022/11/7  0007 11:24
 */
public class WashCoffeeCut {
    public static int bestTime(int[] drinks, int wash, int air, int index, int free) {
        if (index == drinks.length) {
            return 0;
        }
        // index号杯子 决定洗
        int selfClean1 = Math.max(drinks[index], free) + wash;
        int restClean1 = bestTime(drinks, wash, air, index + 1, selfClean1);
        int p1 = Math.max(selfClean1, restClean1);

        // index号杯子 决定挥发
        int selfClean2 = drinks[index] + air;
        int restClean2 = bestTime(drinks, wash, air, index + 1, free);
        int p2 = Math.max(selfClean2, restClean2);
        return Math.min(p1, p2);
    }

    //业务限制模型：index和washFree。。。washfree需要根据业务去确定值
    public static int bestTimeDp(int[] drinks, int wash, int air) {
        int N = drinks.length;
        int maxFree = 0;
        for (int i = 0; i < drinks.length; i++) {
            maxFree = Math.max(maxFree, drinks[i]) + wash;
        }
        int[][] dp = new int[N + 1][maxFree + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int free = 0; free <= maxFree; free++) {
                int selfClean1 = Math.max(drinks[index], free) + wash;
                if (selfClean1 > maxFree) {
                    break; // 因为后面的也都不用填了
                }
                // index号杯子 决定洗
                int restClean1 = dp[index + 1][selfClean1];
                int p1 = Math.max(selfClean1, restClean1);
                // index号杯子 决定挥发
                int selfClean2 = drinks[index] + air;
                int restClean2 = dp[index + 1][free];
                int p2 = Math.max(selfClean2, restClean2);
                dp[index][free] = Math.min(p1, p2);
            }
        }
        return dp[0][0];
    }
}
