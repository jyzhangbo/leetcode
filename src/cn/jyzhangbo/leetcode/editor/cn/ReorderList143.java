/**
给定一个单链表 L 的头节点 head ，单链表 L 表示为： 

 
L0 → L1 → … → Ln - 1 → Ln
 

 请将其重新排列后变为： 

 
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 

 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 

 

 示例 1： 

 

 
输入：head = [1,2,3,4]
输出：[1,4,2,3] 

 示例 2： 

 

 
输入：head = [1,2,3,4,5]
输出：[1,5,2,4,3] 

 

 提示： 

 
 链表的长度范围为 [1, 5 * 10⁴] 
 1 <= node.val <= 1000 
 

 Related Topics 栈 递归 链表 双指针 👍 1374 👎 0

*/
package cn.jyzhangbo.leetcode.editor.cn;

import cn.jyzhangbo.model.ListNode;

public class ReorderList143{
   
    public static void main(String[] args) {
        Solution solution = new ReorderList143().new Solution();
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

    /**
     * 输入：head = [1,2,3,4,5,6,7,8,9,10]
     * 输出：[1,10,2,9,3,8,4,7,5,6]
     *
     * 1. 找到中间
     * 2. 反转后半部分
     * 3. 合并两个链表
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head ==null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;

        l2 = reverse(l2);

        merger(l1, l2);

    }

    private void merger(ListNode l1, ListNode l2) {
        ListNode l1t;
        ListNode l2t;
        while (l1!=null && l2!=null) {
            l1t = l1.next;
            l2t = l2.next;

            l1.next = l2;
            l2.next = l1t;

            l1 = l1t;
            l2 = l2t;
        }
    }
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre =cur;
            cur = temp;
        }
        return pre;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null && fast.next.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}