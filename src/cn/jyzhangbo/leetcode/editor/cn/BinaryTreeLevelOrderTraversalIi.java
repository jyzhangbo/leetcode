/**
给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 

 

 示例 1： 
 
 
输入：root = [3,9,20,null,null,15,7]
输出：[[15,7],[9,20],[3]]
 

 示例 2： 

 
输入：root = [1]
输出：[[1]]
 

 示例 3： 

 
输入：root = []
输出：[]
 

 

 提示： 

 
 树中节点数目在范围 [0, 2000] 内 
 -1000 <= Node.val <= 1000 
 

 Related Topics 树 广度优先搜索 二叉树 👍 727 👎 0

*/
package cn.jyzhangbo.leetcode.editor.cn;

import cn.jyzhangbo.model.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalIi{
   
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root ==null) {
            return res;
        }
        Queue<TreeNode> path = new ArrayDeque<>();
        path.offer(root);

        while (!path.isEmpty()) {
            int size = path.size();
            List<Integer> hang = new ArrayList<>();
            for (int i=0;i<size;i++) {
                TreeNode poll = path.poll();

                hang.add(poll.val);
                if (poll.left != null) {
                    path.offer(poll.left);
                }
                if (poll.right != null) {
                    path.offer(poll.right);
                }
            }
            res.add(0, hang);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}