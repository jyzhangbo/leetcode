//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 816 👎 0

  
package cn.jyzhangbo.leetcode.editor.cn;

import cn.jyzhangbo.model.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal103 {
     
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal103().new Solution();
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> path = new ArrayDeque<>();
        path.offerFirst(root);
        boolean dum = true;
        while (!path.isEmpty()) {
            List<Integer> vals = new ArrayList<>();
            int size = path.size();
            for (int i = 0; i< size; i++) {
                TreeNode temp = path.pollLast();
                if (dum) {
                    vals.add(temp.val);
                } else {
                    vals.add(0, temp.val);
                }
                if (temp.left!=null){
                    path.offerFirst(temp.left);
                }
                if (temp.right!=null) {
                    path.offerFirst(temp.right);
                }
            }
            res.add(vals);
            dum = !dum;

        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}