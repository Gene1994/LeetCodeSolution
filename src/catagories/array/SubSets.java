package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author quzhe
 * @date 2020/1/21 14:51
 * @description 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 */
public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> subsets = subSets.subsets2(nums);
        System.out.println(subsets.size());

    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets2(int[] nums) {
        if(nums == null || nums.length < 1) {
            return res;
        }
        helper(nums, 0, new ArrayList<>());
        return res;
    }
    private void helper(int[] nums, int start, List<Integer> tmp) {
        if (start > nums.length) {
            return;
        }
        res.add(new ArrayList(tmp));
        for (int j = start; j < nums.length; j++) {
            tmp.add(nums[j]);
            helper(nums, j+1, tmp);
            tmp.remove(tmp.size()-1);
        }
    }

}
