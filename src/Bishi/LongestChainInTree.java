package Bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestChainInTree {
    private static List<List<Integer>> tree = new ArrayList<>();
    private static int[] values;
    private static int[] dpAscending; // 用于存储以每个节点为根的最长升序链长度
    private static int[] dpDescending; // 用于存储以每个节点为根的最长降序链长度

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        values = new int[n + 1];
        dpAscending = new int[n + 1];
        dpDescending = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            values[i] = scanner.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs(1, -1); // 从根节点开始DFS，-1表示根节点没有父节点

        int maxChainLength = 0;
        for (int i = 1; i <= n; i++) {
            maxChainLength = Math.max(maxChainLength, Math.max(dpAscending[i], dpDescending[i]));
        }

        System.out.println(maxChainLength);
        scanner.close();
    }

    private static void dfs(int node, int parent) {
        for (int child : tree.get(node)) {
            if (child != parent) {
                dfs(child, node);
                // 更新升序链
                if (values[child] >= values[node]) {
                    dpAscending[node] = Math.max(dpAscending[node], dpAscending[child] + 1);
                }
                // 更降序链
                if (values[child] <= values[node]) {
                    dpDescending[node] = Math.max(dpDescending[node], dpDescending[child] + 1);
                }
            }
        }
        // 每个节点至少算一个长度
        dpAscending[node] = Math.max(dpAscending[node], 1);
        dpDescending[node] = Math.max(dpDescending[node], 1);
    }
}
