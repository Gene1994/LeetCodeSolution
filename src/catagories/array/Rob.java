package array;

/**
 * @author quzhe
 * @date 2020/1/23 17:09
 * @description 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Rob {
    int res = 0;
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return res;
        }
        helper(0, nums, 0);
        return res;
    }

    //回溯法 超出时间限制 需要剪枝
    private void helper(int start, int[] nums, int tmp) {
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            tmp += nums[i];
            res = Math.max(res, tmp);
            helper(i+2, nums, tmp);
            tmp -= nums[i];
        }
    }

    //dp
    public int rob1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] nums = new int[]{1,2,3,1};
        int rob1 = rob.rob(nums);
        int[] nums2 = new int[]{2,7,9,3,1};
        int rob2 = rob.rob(nums2);
        System.out.println(rob1);
        System.out.println(rob2);
    }
}
