package TopCode.回溯.子集;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> subRes = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTracing(nums,0);
        return res;
    }

    void backTracing(int[] nums, int startIndex) {
        res.add(new ArrayList<>(subRes));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            subRes.add(nums[i]);
            backTracing(nums, i + 1);
            subRes.removeLast();
        }
    }
}
