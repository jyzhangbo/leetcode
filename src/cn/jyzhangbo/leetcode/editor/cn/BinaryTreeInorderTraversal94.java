//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1914 👎 0


package cn.jyzhangbo.leetcode.editor.cn;

import cn.jyzhangbo.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal94().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        /**
         * 输入：root = [1,null,2,3]
         * 输出：[1,3,2]
         *
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            handle(res, root);
            return res;
        }

        public void handle(List<Integer> res, TreeNode root) {
            if (root == null) {
                return;
            }
            handle(res, root.left);
            res.add(root.val);
            handle(res, root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}