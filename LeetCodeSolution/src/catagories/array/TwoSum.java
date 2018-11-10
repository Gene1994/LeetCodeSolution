/**
 * @author: create by Gene1994
 * @date:2018/11/10
 */

import java.util.HashMap;
import java.util.Map;

/**
 * No.1 TwoSum
 * Difficulty:Easy

 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].

 */
public class TwoSum {

    //My solution(7ms)
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    //My solution II(32ms)
    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return null;
    }


    /*
    Official solution I

    Complexity Analysis

    Time complexity : O(n^2). For each element,
    we try to find its complement by looping through the rest of array which takes O(n) time.
    Therefore, the time complexity is O(n^2).

    Space complexity : O(1).

     */
    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /*
    Official solution II

    Complexity Analysis:

    Time complexity : O(n). We traverse the list containing nn elements exactly twice.
    Since the hash table reduces the look up time to O(1),
    the time complexity is O(n).

    Space complexity : O(n).
    The extra space required depends on the number of items stored in the hash table,
    which stores exactly nn elements.
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /*
    Official solution III

    Complexity Analysis:

    Time complexity : O(n). We traverse the list containing nn elements only once.
    Each look up in the table costs only O(1) time.

    Space complexity : O(n). The extra space required depends on the number of items stored in the hash table,
    which stores at most nn elements.
     */
    public int[] twoSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //fastest
    public int[] twoSum5(int[] nums, int target) {
        final int il = nums.length;
        int il2 = (il >> 2) - 1;

        int pot = 2;
        while((il2 >>= 1) > 0) pot <<= 1;
        final int bitMod = pot - 1;
        final int[] bucket = new int[pot];
        final int[] linked = new int[il];

        final int firstVal = nums[0];

        for (int i = 1; i < il; i++) {
            int currNum = nums[i];
            int complement = target - currNum;

            if (complement == firstVal) {
                return new int[] { 0, i };
            }

            int complementLLIndex = bucket[complement & bitMod];
            while(complementLLIndex != 0) {
                if(nums[complementLLIndex] == complement) {
                    //Found
                    return new int[] { complementLLIndex, i };
                }
                complementLLIndex = linked[complementLLIndex];
            }
            int currNumLLIndex = currNum & bitMod;
            linked[i] = bucket[currNumLLIndex];
            bucket[currNumLLIndex] = i;
        }
        return null;
    }
}
