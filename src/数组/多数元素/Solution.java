package 数组.多数元素;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }
        System.out.println(map);
        int result = 0;
        for (Map.Entry<Integer,Integer> entry :map.entrySet()) {
            if (entry.getValue() > Math.floor(nums.length / 2.0)) {
                result = entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }
}
