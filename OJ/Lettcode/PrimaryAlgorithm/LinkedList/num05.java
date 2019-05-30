package Lettcode.PrimaryAlgorithms.LinkedList;

/**
 * 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 解法:快慢指针找到中点，反转链表，比较。
 */

import java.util.Scanner;

public class num05 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode now = head;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int number = in.nextInt();
            ListNode node = new ListNode(number);
            now.next = node;
            now = node;
        }
        boolean ans = isPalindrome(head.next);
        System.out.println(ans);
    }

    private static boolean isPalindrome(ListNode head) {
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode twosteps = prehead;
        ListNode onesteps = prehead;
        while (twosteps.next != null){
            onesteps = onesteps.next;
            twosteps = twosteps.next;
            if (twosteps.next != null){
                twosteps = twosteps.next;
            }
        }
        ListNode tail = reverseLinked(onesteps.next);
        while (tail != null){
            if (tail.val != head.val){
                return false;
            }
            else {
                tail = tail.next;
                head = head.next;
            }
        }
        return true;
    }

    private static ListNode reverseLinked(ListNode head) {
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
