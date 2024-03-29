package cn.jyzhangbo.firstStage;

import cn.jyzhangbo.model.ListNode;
import cn.jyzhangbo.tools.NodeTools;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * @author zhangbo221
 * @date 2023/7/13
 */
public class Solution_21 {

    public static void main(String[] args) {
        System.out.println(mergeTwoLists(NodeTools.init(1,2,3), NodeTools.init(2,3,4,5,6)));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (list1!= null && list2!= null){
            if (list1.val < list2.val){
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }

        if (list1 != null) {
            head.next = list1;
        } else if (list2 != null) {
            head.next = list2;
        }
        return dummy.next;
    }
}
