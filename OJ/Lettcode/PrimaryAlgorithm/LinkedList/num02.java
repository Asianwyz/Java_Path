package Lettcode.PrimaryAlgorithms.LinkedList;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */

public class num02 {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(9);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode tmp = node;
        while (tmp != null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
        int n = 4;
        ListNode head = solution(node,n);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static ListNode solution(ListNode head, int n) {
        int count = 1;
        ListNode tmp = head;
        while (tmp.next != null){
            ++count;
            tmp = tmp.next;
        }
        tmp = head;
        for (int i = 1; i < count - n; i++) {
            tmp = tmp.next;
        }
        if (count == n){
            head = head.next;
        }
        else{
            if (n == 1) {
                tmp.next = null;
            }
            else{
                tmp = tmp.next;
                tmp.val = tmp.next.val;
                tmp.next = tmp.next.next;
            }
        }
        return head;
    }

    private static void deleteNode(ListNode tmp) {
        tmp.val = tmp.next.val;
        tmp.next = tmp.next.next;
    }
}
