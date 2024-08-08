package TopCode.动态规划.最长回文子串;

public class Solution {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        String result = "";
        int max = 0;
        int[][] dp = new int[len + 1][len + 1];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else {
                    dp[i][j] =  Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    result = s.substring(i,j + 1);
                }
            }
        }
//        for (int i = 0; i < len + 1; i++) {
//            for (int j = 0; j < len + 1; j++) {
//                System.out.print(dp[i][j] + " ");
//                if (j == len) {
//                    System.out.print("\n");
//                }
//            }
//        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
