package TopCode.top8_快速排序;

import java.util.Random;

public class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0, nums.length -1);
        return nums;
    }

    void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int position = partition(nums, left, right);
            quickSort(nums, left, position - 1);
            quickSort(nums, position + 1, right);
        }
    }

    int random(int[] nums, int left, int right) {
        int index = new Random().nextInt(right - left + 1) + left;
        int tmp = nums[left];
        nums[left] = nums[index];
        nums[index] = tmp;
        return partition(nums, left,right);
    }

    int partition(int[] nums, int left, int right) {
        int base = nums[left];
        while (left < right) {
            while (left <right && nums[right] >= base) {
                right--;
            }
            nums[left] = nums[right];
            while (left <right && nums[left] <= base) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = base;
        return left;
    }
}
