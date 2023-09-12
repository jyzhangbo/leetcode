//给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics 链表 👍 1038 👎 0

  
package cn.jyzhangbo.leetcode.editor.cn;

import cn.jyzhangbo.model.ListNode;

public class RemoveDuplicatesFromSortedList83 {
     
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList83().new Solution();
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
     * 输入：head = [1,1,2,3,3]
     * 输出：[1,2,3]
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;

        while (cur!=null && cur.next!=null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}