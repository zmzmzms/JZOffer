package TopCode.回溯.复原IP地址;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<String> result = new ArrayList<>();
    LinkedList<String> subIP = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        backTracing(s,0);
        return result;
    }

    void backTracing(String s, int startIndex) {
        if (startIndex >= s.length() && subIP.size() == 4) {
            String ss = subIP.get(0);
            for (int i = 1; i < subIP.size(); i++) {
                ss = ss +"."+subIP.get(i);
            }
            result.add(ss);
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (i > startIndex && s.charAt(startIndex) == '0') {
                continue;
            }
            String num = s.substring(startIndex, i + 1);
            if (num.length() > 3) {
                continue;
            }
            if ( Integer.parseInt(num) >255) {
                continue;
            }
            if (subIP.size() >= 4) {
                continue;
            }
            subIP.add(num);
            backTracing(s, i + 1);
            subIP.removeLast();
        }
    }
}
