package TopCode.动态规划.标准完全背包;

import java.util.Scanner;

public class Solution {
    public static int bag(int[] weights, int[] values, int bagSize) {
        int dp[] = new int[bagSize + 1];
        dp[0] = 0;
        for (int i = 0; i < weights.length; i++) {
            for (int j = weights[i]; j < bagSize + 1; j++) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }
        return dp[bagSize];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int V = in.nextInt();
        int[] weights = new int[N];
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = in.nextInt();
            values[i] = in.nextInt();
        }
        System.out.println(bag(weights,values,V));
    }
}
