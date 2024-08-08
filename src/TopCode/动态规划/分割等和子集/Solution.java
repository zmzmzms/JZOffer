package TopCode.动态规划.分割等和子集;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int rowLen = nums.length;
        int colLen = target + 1;
        int[][] dp = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < colLen; i++) {
            if (i >= nums[0]) {
                dp[0][i] = nums[0];
            }else {
                dp[0][i] = 0;
            }
        }
        // 注意i j的起始值
        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (j < nums[i]) { // j - nums[i]必须得大于等于0，所以需要这个分支
                    // 第i个物品重量大于背包容量，所以放不进去，放不进去等于dp[i - 1][j]
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }
        }
        return dp[rowLen - 1][colLen - 1] == target;
    }
}
