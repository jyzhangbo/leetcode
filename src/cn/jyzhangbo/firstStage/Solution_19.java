package cn.jyzhangbo.firstStage;

import cn.jyzhangbo.model.ListNode;
import cn.jyzhangbo.tools.NodeTools;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * @author zhangbo221
 * @date 2023/7/13
 */
public class Solution_19 {

    public static void main(String[] args) {
        System.out.println(removeNthFromEnd(NodeTools.init(2,3,4), 1));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
       return null;
    }
}
