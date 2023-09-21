/**
给定一个单链表的头节点 head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。 

 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。 

 

 示例 1: 

 

 
输入: head = [-10,-3,0,5,9]
输出: [0,-3,9,-10,null,5]
解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
 

 示例 2: 

 
输入: head = []
输出: []
 

 

 提示: 

 
 head 中的节点数在[0, 2 * 10⁴] 范围内 
 -10⁵ <= Node.val <= 10⁵ 
 

 Related Topics 树 二叉搜索树 链表 分治 二叉树 👍 858 👎 0

*/
package cn.jyzhangbo.leetcode.editor.cn;

import cn.jyzhangbo.model.ListNode;
import cn.jyzhangbo.model.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree109{
   
    public static void main(String[] args) {
        Solution solution = new ConvertSortedListToBinarySearchTree109().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return handle(list, 0, list.size() - 1);

    }

    public TreeNode handle(List<Integer> list, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = (l + r) /2;
        TreeNode root = new TreeNode(list.get(m));
        root.left = handle(list, l, m - 1);
        root.right = handle(list, m + 1, r);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}