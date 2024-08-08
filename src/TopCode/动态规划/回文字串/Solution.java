package TopCode.动态规划.回文字串;

public class Solution {
    public int countSubstrings(String s) {
        // dp[i][j]:以i为头，j为尾的字符串[i,j]是否是回文字串

        int len = s.length();
        int result = 0;
        boolean[][] dp = new boolean[len][len];
        // dp[i][j]的状态由dp[i + 1][j - 1]得来，所以i要倒序遍历，而j要满足[i,j]区间，所以j>=i
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // i=j,j-1=1对应a,aa,都是回文字串
                    if (Math.abs(i - j) <= 1) {
                        result++;
                        dp[i][j] = true;
                    }else if (dp[i + 1][j - 1]){
                        // a...a依赖[i+1,j-1]是否是回文字串
                        result++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return result;
    }
}
