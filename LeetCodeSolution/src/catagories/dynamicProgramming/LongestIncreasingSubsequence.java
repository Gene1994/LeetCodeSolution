package dynamicProgramming;

/**
 * @author: create by Gene1994
 * @date:2018/12/31
 */

import java.util.Map;

/**
 * No.300 Longest Increasing Subsequence
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        if (nums == null)
            return res;
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] >nums[j]){
                    dp[i] = Math.max(dp[i] - 1, dp[j]) + 1;
                }
            }
            res = Math.max(res, dp[i]);
        }
//        for (int i = 0; i < len; i++) {
//            res = Math.max(res, dp[i]);
//        }
        return res;
    }
}
