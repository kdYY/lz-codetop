package number;

public class Solution_143 {
    /**
     * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
     *
     * L0 → L1 → … → Ln - 1 → Ln
     * 请将其重新排列后变为：
     *
     * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reorder-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void reorderList(ListNode head) {
        ListNode low = head;
        ListNode fast = head;
        // 两种判断是等效的
        // fast.next != null && fast.next.next != null
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        ListNode mid = low;
        ListNode revertHead = revertLit(mid.next);
        mid.next = null;
        //组合
        mergeList(head, revertHead);
    }

    public static ListNode revertLit(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        // 反转[mid+1, end]的链表
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;
            l1.next = l2;
            l2.next = l1_tmp;
            l1 = l1_tmp;
            l2 = l2_tmp;
        }
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        reorderList(listNode1);
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
