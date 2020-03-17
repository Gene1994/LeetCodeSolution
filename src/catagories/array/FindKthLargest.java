package array;

import java.util.Arrays;

/**
 * @author quzhe
 * @date 2020/2/10 13:23
 * @description array
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
