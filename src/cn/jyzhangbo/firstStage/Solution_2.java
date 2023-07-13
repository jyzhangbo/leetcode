package cn.jyzhangbo.firstStage;

import cn.jyzhangbo.model.ListNode;
import cn.jyzhangbo.tools.NodeTools;

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * @author zhangbo221
 * @date 2023/7/13
 */
public class Solution_2 {

    public static void main(String[] args) {
        System.out.println(addTwoNumbers(NodeTools.init(9,9,9,9,9,9,9), NodeTools.init(9,9,9,9)));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode result = new ListNode();
        dummy.next = result;
        int temp = 0;
        int sum = 0, a = 0, b = 0;
        while (l1 != null || l2 != null || temp != 0){
            if (l1 != null && l2 != null) {
                a = l1.val;
                b = l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if(l1 == null && l2 != null) {
                a = 0;
                b = l2.val;
                l2 = l2.next;
            } else if(l1 != null && l2 == null) {
                b = 0;
                a = l1.val;
                l1 = l1.next;
            } else {
                a = 0;
                b = 0;
            }

            sum = (a + b + temp) % 10;
            temp = (a + b + temp) / 10;

            ListNode node = new ListNode(sum);
            result.next = node;

            result = result.next;

        }
        return dummy.next.next;
    }
}
