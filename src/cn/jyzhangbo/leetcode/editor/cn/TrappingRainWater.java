/**
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 

 

 示例 1： 

 

 
输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
 

 示例 2： 

 
输入：height = [4,2,0,3,2,5]
输出：9
 

 

 提示： 

 
 n == height.length 
 1 <= n <= 2 * 10⁴ 
 0 <= height[i] <= 10⁵ 
 

 Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4641 👎 0

*/
package cn.jyzhangbo.leetcode.editor.cn;

public class TrappingRainWater{
   
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] nums) {
        return dongtai(nums);
    }

    public int dongtai(int[] nums) {
        int res = 0;
        int len = nums.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        for (int i = 1; i< len-1; i++) {
            leftMax[i] = Math.max(leftMax[i-1], nums[i - 1]);
        }

        for (int i = len - 2; i > 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], nums[i+1]);
        }

        for (int i = 1; i< len-1; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min- nums[i] >0) {
                res = res + min - nums[i];
            }
        }
        return res;
    }

    public int baoli(int[] nums) {
        int res = 0;
        int len = nums.length;
        for (int i = 1; i< len-1; i++) {
            int leftmax = nums[0];
            int rightmax = nums[len - 1];
            for (int j = 0; j< i; j++) {
                leftmax = Math.max(leftmax, nums[j]);
            }
            for (int j = len-1; j> i; j--) {
                rightmax = Math.max(rightmax, nums[j]);
            }
            if (Math.min(leftmax, rightmax) - nums[i] >0) {
                res = res + Math.min(leftmax, rightmax) - nums[i];
            }
        }
        return res;
    }


    /**
     * 一层一层统计
     * @param nums
     * @return
     */
    public int ceng(int[] nums) {
        int result = 0;
        int depth = 0;
        while (true) {
            int count = 0;
            int start = -1;
            for (int i = 0; i< nums.length; i++) {
                if (nums[i] > depth) {
                    if (start !=-1) {
                        result = result + i - start - 1;
                        start = i;
                    } else {
                        start = i;
                    }
                    count++;
                }
            }
            depth++;
            if (count < 2) {
                return result;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}