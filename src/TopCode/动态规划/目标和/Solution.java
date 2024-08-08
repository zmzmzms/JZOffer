package TopCode.动态规划.目标和;

public class Solution {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        // 必不可少
        if(sum < target) {
            return 0;
        }
        int neg = (sum - target) / 2;
        if ((sum - target) % 2 == 1) {
            return 0;
        }
        int colLen = neg + 1;
        int[] dp = new int[colLen];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = neg; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[colLen-1];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(findTargetSumWays(nums, 3));
    }
}
