package TopCode.动态规划.完全平方数;

public class Solution {
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i < n+1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // i的起始为1，注意思考i的含义
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j - i*i] + 1,dp[j]);
            }
        }
        for (int i = 0; i < n + 1; i++) {
            System.out.print(dp[i] +" ");
        }
        return dp[n];
    }

    public static void main(String[] args) {
        numSquares(12);
    }
}
