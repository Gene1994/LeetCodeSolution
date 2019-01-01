/**
 * @author: create by Gene1994
 * @date:2018/11/13
 */

/**
 * No.35 Search Insert Position
 *
 * Difficulty:Easy
 *
 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Example 1:
 Input: [1,3,5,6], 5
 Output: 2

 Example 2:
 Input: [1,3,5,6], 2
 Output: 1

 Example 3:
 Input: [1,3,5,6], 7
 Output: 4

 Example 4:
 Input: [1,3,5,6], 0
 Output: 0
 */
public class SearchInsertPosition {
    //My solution
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }else {
                if(target < nums[0]){return 0;}
                if(target > nums[nums.length-1]){return nums.length;}
                if(nums[i] < target && nums[i+1] > target) {
                    return i+1;
                }
            }

        }
        return 0;
    }

    //Most popular by @AmmsA
    public int searchInsert1(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}
