package TopCode.回溯.组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int sum = 0;
        Arrays.sort(candidates);
        backTracing(candidates,target,0);
        return result;
    }
    void backTracing(int[] candidates, int target,int startIndex) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            backTracing(candidates, target - candidates[i], i);
            path.removeLast();
        }
    }
}
