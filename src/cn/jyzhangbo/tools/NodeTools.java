package cn.jyzhangbo.tools;

import cn.jyzhangbo.model.ListNode;

/**
 * @author zhangbo221
 * @date 2023/7/13
 */
public class NodeTools {

    public static ListNode init(int... vals) {
        if (vals.length == 0) {
            return new ListNode();
        }
        ListNode head = null, tail = null;

        for (int i = 0; i < vals.length; i++) {
            if (head == null) {
                head = tail = new ListNode(vals[i]);
            } else {
                tail.next = new ListNode(vals[i]);
                tail = tail.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] vals = {3, 42, 6, 7};
        System.out.println(init(vals));
    }

}
