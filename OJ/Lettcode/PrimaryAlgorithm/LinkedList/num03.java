package Lettcode.PrimaryAlgorithms.LinkedList;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 迭代解法
 * 递归解法很有趣，空间多
 */
public class num03 {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(9);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        ListNode head = solution(node);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static ListNode solution(ListNode head) {
        ListNode last = null;
        ListNode now = head;
        while (now != null){
            ListNode next = now.next;
            now.next = last;
            last = now;
            now = next;
        }
        return last;
    }
}
