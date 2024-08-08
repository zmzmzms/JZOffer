package TopCode.回溯.分割回文子串;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<String>> result = new ArrayList<>();
    LinkedList<String> subRes = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtracing(s,0);
        return result;
    }

    void backtracing(String s, int start) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(subRes));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isHuiWen(s,start,i)) {
                subRes.add(s.substring(start,i+1));
            }else {
                continue;
            }
            backtracing(s,i+1);
            subRes.removeLast();
        }
    }

    boolean isHuiWen(String s, int start ,int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
