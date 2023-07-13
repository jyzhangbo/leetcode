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

        ListNode dummyNode = new ListNode();
        ListNode tempNode = new ListNode(vals[0]);

        dummyNode.next = tempNode;

        for (int i = 1; i < vals.length; i++) {
            ListNode node = new ListNode(vals[i]);
            tempNode.next = node;
            tempNode = tempNode.next;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] vals = {3, 42, 6, 7};
        System.out.println(init(vals));
    }

}
