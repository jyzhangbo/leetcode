//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics 链表 👍 1646 👎 0

  
package cn.jyzhangbo.leetcode.editor.cn;

import cn.jyzhangbo.model.ListNode;
import cn.jyzhangbo.tools.NodeTools;

public class ReverseLinkedListIi92 {
     
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi92().new Solution();
        ListNode init = NodeTools.init(1, 2, 3, 4, 5);
        solution.reverse(init);
        System.out.println(init);
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
class Solution {
    /**             pre            right
     * 输入：head = [1   ,   2,  3,  4,  5], left = 2, right = 4
     * 输出：[1,4,3,2,5]
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);

        ListNode pre = dummy;
        for (int i = 0; i < left-1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i =0;i<right - left + 1;i++){
            rightNode = rightNode.next;
        }

        ListNode end = rightNode.next;
        ListNode leftNode = pre.next;

        pre.next = null;
        rightNode.next = null;

        reverse(leftNode);

        pre.next = rightNode;
        leftNode.next = end;

        return dummy.next;
    }

    public void reverse(ListNode head) {
        ListNode dummy = null;
        ListNode cur = head;
        while (cur!=null) {
            ListNode temp = cur.next;
            cur.next = dummy;
            dummy = cur;
            cur = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}