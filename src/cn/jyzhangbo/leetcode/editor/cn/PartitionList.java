/**
给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 

 你应当 保留 两个分区中每个节点的初始相对位置。 

 

 示例 1： 
 
 
输入：head = [1,4,3,2,5,2], x = 3
输出：[1,2,2,4,3,5]
 

 示例 2： 

 
输入：head = [2,1], x = 2
输出：[1,2]
 

 

 提示： 

 
 链表中节点的数目在范围 [0, 200] 内 
 -100 <= Node.val <= 100 
 -200 <= x <= 200 
 

 Related Topics 链表 双指针 👍 751 👎 0

*/
package cn.jyzhangbo.leetcode.editor.cn;

import cn.jyzhangbo.model.ListNode;
import cn.jyzhangbo.tools.NodeTools;

public class PartitionList{
   
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        System.out.println(solution.partition(NodeTools.init(1,4,5,2,5,2), 3));
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
     * 输入：head = [1,4,3,2,5,2], x = 3
     * 输出：[1,2,2,4,3,5]
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode dummy1 = new ListNode(0);
        ListNode a = dummy;
        ListNode b = dummy1;

        while (head!=null) {
            if (head.val < x) {
                a.next = head;
                a = a.next;
            } else {
                b.next = head;
                b = b.next;
            }
            head = head.next;
        }
        b.next = null;
        if (dummy1.next !=null) {
            a.next = dummy1.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}