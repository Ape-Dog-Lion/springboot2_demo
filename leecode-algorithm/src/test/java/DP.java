import org.junit.Test;

import java.util.Arrays;

/**
 * 动态规划
 */
public class DP {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) dp[i] = Integer.MAX_VALUE;

        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /**
     * coinChange
     * <p>
     * https://blog.csdn.net/lym940928/article/details/90111598
     * https://v.youku.com/v_show/id_XMzg0MDcyMDI0MA==.html?
     */
    @Test
    public void test1() {
        int i = coinChange(new int[]{1, 2, 5, 7, 10}, 14);
        System.out.print(i);
    }


    /**
     * 【Leetcode】62. 不同路径
     * https://segmentfault.com/a/1190000016315625
     */
    @Test
    public void test2() {
        int m = 3, n = 7;
        System.out.println(uniquePaths(m, n));
        System.out.println(uniquePaths1(m, n));
    }


    private int uniquePaths(int m, int n) {
        int[][] ways = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) ways[i][j] = 1;
                else ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
            }
        }
        return ways[m - 1][n - 1];
    }


    public int uniquePaths1(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] += res[j - 1];
                System.out.println("i=" + i + "_" + "j=" + j + ":" + Arrays.toString(res));
            }
        }
        return res[n - 1];
    }
}
