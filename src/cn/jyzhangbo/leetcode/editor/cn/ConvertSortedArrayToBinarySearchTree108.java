/**
给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。 

 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。 

 

 示例 1： 
 
 
输入：nums = [-10,-3,0,5,9]
输出：[0,-3,9,-10,null,5]
解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：

 

 示例 2： 
 
 
输入：nums = [1,3]
输出：[3,1]
解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 

 

 提示： 

 
 1 <= nums.length <= 10⁴ 
 -10⁴ <= nums[i] <= 10⁴ 
 nums 按 严格递增 顺序排列 
 

 Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 1392 👎 0

*/
package cn.jyzhangbo.leetcode.editor.cn;

import cn.jyzhangbo.model.TreeNode;

public class ConvertSortedArrayToBinarySearchTree108{
   
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree108().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    /**
     * 输入：nums = [-10,-3,0,5,9]
     * 输出：[0,-3,9,-10,null,5]
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return handle(nums, 0, nums.length-1);
    }

    public TreeNode handle(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = (l + r) /2;
        TreeNode node = new TreeNode(nums[m]);
        node.left = handle(nums, l, m - 1);
        node.right = handle(nums, m + 1, r);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}