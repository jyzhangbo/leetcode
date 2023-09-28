/**
给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。

 
 
 每条从根节点到叶节点的路径都代表一个数字： 
 
 

 
 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。 
 

 计算从根节点到叶节点生成的 所有数字之和 。 

 叶节点 是指没有子节点的节点。 

 

 示例 1： 
 
 
输入：root = [1,2,3]
输出：25
解释：
从根到叶子节点路径 1->2 代表数字 12
从根到叶子节点路径 1->3 代表数字 13
因此，数字总和 = 12 + 13 = 25 

 示例 2： 
 
 
输入：root = [4,9,0,5,1]
输出：1026
解释：
从根到叶子节点路径 4->9->5 代表数字 495
从根到叶子节点路径 4->9->1 代表数字 491
从根到叶子节点路径 4->0 代表数字 40
因此，数字总和 = 495 + 491 + 40 = 1026
 

 

 提示： 

 
 树中节点的数目在范围 [1, 1000] 内 
 0 <= Node.val <= 9 
 树的深度不超过 10 
 

 Related Topics 树 深度优先搜索 二叉树 👍 683 👎 0

*/
package cn.jyzhangbo.leetcode.editor.cn;

import cn.jyzhangbo.model.TreeNode;

public class SumRootToLeafNumbers129{
   
    public static void main(String[] args) {
        Solution solution = new SumRootToLeafNumbers129().new Solution();
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(1);
        node3.left = node1;
        node3.right = node2;
        System.out.println(solution.sumNumbers(node3));
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
     * 输入：root = [4,9,0,5,1]
     * 输出：1026
     * 解释：
     * 从根到叶子节点路径 4->9->5 代表数字 495
     * 从根到叶子节点路径 4->9->1 代表数字 491
     * 从根到叶子节点路径 4->0 代表数字 40
     * 因此，数字总和 = 495 + 491 + 40 = 1026
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return handle(root,0);
    }

    public int handle(TreeNode root, int path) {
        if (root == null) {
            return 0;
        }
        path = path * 10 + root.val;
        if (root.left == null && root.right == null) {
            return path;
        }
        return handle(root.left, path) + handle(root.right, path);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}