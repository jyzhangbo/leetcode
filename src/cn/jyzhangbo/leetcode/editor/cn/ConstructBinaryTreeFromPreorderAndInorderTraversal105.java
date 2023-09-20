//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2082 👎 0

  
package cn.jyzhangbo.leetcode.editor.cn;

import cn.jyzhangbo.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
     
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal105().new Solution();
        solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> temp = new HashMap<>();
        int n = preorder.length;
        for (int i =0; i< n; i++) {
            temp.put(inorder[i], i);
        }

        return handle(preorder, temp,0, n-1, 0,n-1);
    }

    /**
     * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * 输出: [3,9,20,null,null,15,7]
     * @param preorder
     * @param temp
     * @param prel
     * @param prer
     * @param inol
     * @param inor
     * @return
     */
    public TreeNode handle(int[] preorder,Map<Integer, Integer> temp,int prel,int prer,int inol,int inor) {
        if (prel > prer) {
            return null;
        }
        int val = preorder[prel];
        TreeNode root = new TreeNode(val);

        int rootIndex = temp.get(val);

        int leftLen = rootIndex - inol;

        root.left = handle(preorder, temp, prel+1,prel + leftLen, inol,rootIndex-1);
        root.right = handle(preorder, temp, prel + leftLen +1,prer, rootIndex+1,inor);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}