/**
给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 

 如果数组中不存在目标值 target，返回 [-1, -1]。 

 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 

 

 示例 1： 

 
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4] 

 示例 2： 

 
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1] 

 示例 3： 

 
输入：nums = [], target = 0
输出：[-1,-1] 

 

 提示： 

 
 0 <= nums.length <= 10⁵ 
 -10⁹ <= nums[i] <= 10⁹ 
 nums 是一个非递减数组 
 -10⁹ <= target <= 10⁹ 
 

 Related Topics 数组 二分查找 👍 2432 👎 0

*/
package cn.jyzhangbo.leetcode.editor.cn;

public class FindFirstAndLastPositionOfElementInSortedArray{
   
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        System.out.println(solution.searchRange(new int[]{5,7,7,8,8,10}, 8));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = find(nums, target, true);
        int r = find(nums, target, false) - 1;

        if (l <= r && r <= nums.length && nums[l] == target && nums[r] == target) {
            return new int[] {l,r};
        } else {
            return new int[] {-1, -1};
        }

    }

    public int find(int[] nums, int target, boolean temp) {
        int l = 0;
        int r = nums.length - 1;
        int ans = nums.length;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] > target || (temp && nums[m] >= target)) {
                r = m - 1;
                ans = m;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}