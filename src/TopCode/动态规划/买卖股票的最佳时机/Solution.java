package TopCode.动态规划.买卖股票的最佳时机;

public class Solution {
    public int maxProfit(int[] prices) {
//        int max = 0;
//        int[][] value = new int[prices.length][prices.length];
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                value[i][j] = prices[j] - prices[i];
//                if (value[i][j] > max) {
//                    max = value[i][j];
//                }
//            }
//        }
//        return max;

        //dp[i][0]：第i天持有股票拥有的最大现金
        //dp[i][1]：第i天不持有股票拥有的最大现金
        int dp[][] = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            // 第i天持有股票  1、第i-1天就持有股票 2、第i天买入
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            // 第i天不持有股票  1、第i-1天就不持有股票 2、第i天卖出 = 第i-1天持有股票的现金+今天的价格
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
}
