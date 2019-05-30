package Lettcode.PrimaryAlgorithms.LinkedList;

import java.util.Scanner;

/**
 * 环形链表找环开始的位置：
 * 快慢指针找到环中相遇的位置，然后从表头和相遇处一步一步走，相遇的即时环开始的位置
 *
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *
 *
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 */

public class num06 {
    public static void main(String[] args) {
//        ListNode head = new ListNode(0);
//        ListNode now = head;
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        for (int i = 0; i < n; i++) {
//            int number = in.nextInt();
//            ListNode node = new ListNode(number);
//            now.next = node;
//            now = node;
//        }
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        boolean ans = hascycle(node1.next);
        System.out.println(ans);
    }

    private static boolean hascycle(ListNode head) {
        if (head == null)
            return false;
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode twosteps = prehead;
        ListNode onesteps = prehead;
        while (twosteps != null){
            onesteps = onesteps.next;
            twosteps = twosteps.next;
            if (twosteps == null)
                return false;
            twosteps = twosteps.next;
            if (onesteps == twosteps){
                return true;
            }
        }
        return false;
    }
}
