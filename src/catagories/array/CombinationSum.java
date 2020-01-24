package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author quzhe
 * @date 2020/1/22 21:53
 * @description 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/combination-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length < 1) {
            return res;
        }
        helper(candidates, 0, target, new ArrayList<>());
        return res;
    }

    private void helper(int[] candidates, int start, int target, List<Integer> tmp) {
        int sum = 0;
        for (int i : tmp) {
            sum += i;
        }
        if (sum == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            helper(candidates, i, target, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] ints = new int[] {2, 3, 5};
        List<List<Integer>> lists = combinationSum.combinationSum(ints, 8);
        System.out.println(lists);
    }
}
