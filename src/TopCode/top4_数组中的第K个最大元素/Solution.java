package TopCode.top4_数组中的第K个最大元素;

import java.util.PriorityQueue;
import java.util.Random;

public class Solution {
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        for (int i = 0; i < nums.length; i++) {
//            queue.add(nums[i]);
//            if (queue.size() > k) {
//                queue.poll();
//            }
//        }
//        return queue.peek();
//    }

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,0,nums.length - 1, k);
    }

    int quickSort(int nums[], int left, int right, int k) {
        int p = partition(nums, left, right);
        if (p == k - 1) {
            return nums[p];
        }else if (p < k - 1){
            return quickSort(nums, p + 1,right, k);
        }else {
            return quickSort(nums, left, p - 1, k);
        }
    }

    int partition(int nums[], int left, int right) {
        int ranIndex = new Random().nextInt(right - left  +1) + left;
        int tmp = nums[left];
        nums[left] = nums[ranIndex];
        nums[ranIndex] = tmp;
        int base = nums[left];
        while (left < right) {
            while (left < right && nums[right] <= base) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] >= base) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = base;
        return left;
    }
}
