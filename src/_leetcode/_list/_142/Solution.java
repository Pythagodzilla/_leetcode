package _leetcode._list._142;

/**
 * @Description: 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 * @Author: matreeix
 * @Date: 2019/8/13 20:50
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return val+"";
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;//慢指针
        ListNode fast = head;//快指针
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        //将快指针放在头结点重新走，当它再次与慢指针相遇时就是入环节点
        /**
         * x1:head到入环节点的距离；
         * x2:slow入环后到与fast相遇走的距离；
         * x3:fast比slow多走的距离;
         * x1 + x2 = x3,即有 X1 = X3 - X2;
         *
         * */
        fast = head;
        while (fast != slow) {
            fast = fast.next;//退出循环时走了x1
            slow = slow.next;//退出循环时走了X3 - X2
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
//        listNode5.next = null;
        listNode5.next = listNode3;

        System.out.println(detectCycle(listNode1));

    }


}
