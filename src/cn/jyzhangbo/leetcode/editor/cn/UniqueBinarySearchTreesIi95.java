//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
// 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 👍 1479 👎 0

  
package cn.jyzhangbo.leetcode.editor.cn;

import cn.jyzhangbo.model.ListNode;
import cn.jyzhangbo.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesIi95 {
     
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi95().new Solution();
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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        return handle(1, n);
    }

    public List<TreeNode> handle (int start, int end) {
        List<TreeNode> allNode = new ArrayList<>();
        if (start > end) {
            allNode.add(null);
            return allNode;
        }

        //从1是根节点开始处理到n是根节点
        for (int i = start; i<= end; i++) {

            //处理左边
            List<TreeNode> left = handle(start, i - 1);

            //处理右边
            List<TreeNode> right = handle(i + 1, end);

            // 按照顺序从左边和右边各选出一个，和根节点i组成一个二叉搜索树
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    allNode.add(cur);
                }
            }
        }
        return allNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}