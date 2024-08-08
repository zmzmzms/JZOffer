import java.util.Scanner;

public class Solution {
    /**
     * 小明是一位科学家，他需要参加一场重要的国际科学大会，以展示自己的最新研究成果。他需要带一些研究材料，
     * 但是他的行李箱空间有限。这些研究材料包括实验设备、文献资料和实验样本等等，它们各自占据不同的空间，
     * 并且具有不同的价值。小明的行李空间为 N，问小明应该如何抉择，
     * 才能携带最大价值的研究材料，每种研究材料只能选择一次，并且只有选与不选两种选择，不能进行切割。
     * 第一行包含两个正整数，第一个整数 M 代表研究材料的种类，第二个正整数 N，代表小明的行李空间。
     * 第二行包含 M 个正整数，代表每种研究材料的所占空间。
     * 第三行包含 M 个正整数，代表每种研究材料的价值。
     * 6 1
     * 2 2 3 1 5 2
     * 2 3 1 5 4 3
     * 输出一个整数，代表小明能够携带的研究材料的最大价值。
     */
    public static int maxValue(int m,int n, int[] space, int[] value) {
        int[][] dp = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            if (space[0] <= i) {
                dp[0][i] = value[0];
            }else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (space[i] > j ){  // why?加了if就能过
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - space[i]] + value[i]);
                }
//                System.out.println("dp["+i+"]["+j+"]:"+dp[i][j]);
            }
        }
        return dp[m-1][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] space = new int[m];
        int[] value = new int[m];
        for (int i = 0; i < m; i++) {
            space[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            value[i] = scanner.nextInt();
        }
        int res = maxValue(m,n,space,value);
        System.out.println(res);
    }
}
