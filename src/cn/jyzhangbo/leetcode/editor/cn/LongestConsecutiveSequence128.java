/**
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 

 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 

 

 示例 1： 

 
输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 

 示例 2： 

 
输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
 

 

 提示： 

 
 0 <= nums.length <= 10⁵ 
 -10⁹ <= nums[i] <= 10⁹ 
 

 Related Topics 并查集 数组 哈希表 👍 1826 👎 0

*/
package cn.jyzhangbo.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence128{
   
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence128().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }
        int maxRes = 0;

        for (int num : num_set) {

            if (num_set.contains(num - 1)) {
                continue;
            }

            int currentNum = num;
            int currentStreak = 1;

            while (num_set.contains(currentNum+1)) {
                currentNum++;
                currentStreak++;
            }

            maxRes = Math.max(maxRes, currentStreak);
        }

        return maxRes;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}