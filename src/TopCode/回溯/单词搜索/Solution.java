package TopCode.回溯.单词搜索;

import java.util.ArrayList;

public class Solution {
    String word;
    boolean has;
    StringBuilder path = new StringBuilder();
    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.has = false;
        int m = board.length;
        int n = board[0].length;
        int[][] used = new int[m][n];
        dfs(0,0,used,board,0);
        return has;
    }

    void dfs(int si, int sj,int[][] used,char[][] board,int op) {
        if (si < 0|| sj < 0|| si >= board.length || sj >= board.length) return;
        if (has == true) return;
        if (used[si][sj] == 1) return;
        if (path.length() == word.length()) {
            word.equals(path.toString());
            has = true;
            return;
        }
        for (int i = si; i < used.length; i++) {
            for (int j = sj; j < used[0].length; j++) {
                path.append(board[i][j]);
                used[i][j] = 1;
                if (op == 1) {
                    dfs(i - 1,j,used,board,1);
                    dfs(i,j + 1,used,board,4);
                    dfs(i,j - 1,used,board,3);
                }else if (op == 2) {
                    dfs(i + 1,j,used,board,2);
                    dfs(i,j + 1,used,board,4);
                    dfs(i,j - 1,used,board,3);
                }else if (op == 3) {
                    dfs(i - 1,j,used,board,1);
                    dfs(i + 1,j,used,board,2);
                    dfs(i,j - 1,used,board,3);
                }else {
                    dfs(i - 1,j,used,board,1);
                    dfs(i + 1,j,used,board,2);
                    dfs(i,j + 1,used,board,4);
                }
                used[i][j] = 0;
                path.delete(path.length()-1,path.length()-1);
            }
        }
    }
}
