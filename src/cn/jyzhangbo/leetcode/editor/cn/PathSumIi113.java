//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 1039 👎 0

  
package cn.jyzhangbo.leetcode.editor.cn;

import cn.jyzhangbo.model.TreeNode;

import java.util.*;

public class PathSumIi113 {
     
    public static void main(String[] args) {
        Solution solution = new PathSumIi113().new Solution();
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(root, targetSum, res, path);
        return res;
    }

    /**
     * 深度优先
     * @param root
     * @param targetSum
     * @param res
     * @param path
     */
    public void dfs(TreeNode root, int targetSum, List<List<Integer>> res, Deque<Integer> path) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum = targetSum - root.val;

        if (root.left == null && root.right == null && targetSum == 0){
            res.add(new ArrayList<>(path));
        }

        dfs(root.left, targetSum, res, path);
        dfs(root.right, targetSum, res, path);
        path.pollLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}