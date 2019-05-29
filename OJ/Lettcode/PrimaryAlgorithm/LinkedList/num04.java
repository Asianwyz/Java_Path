package Lettcode.PrimaryAlgorithms.LinkedList;

/**
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */

import java.util.Scanner;

public class num04 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        linked(l1,1);
        linked(l2,2);
        ListNode head = solution(l1,l2);
        while (head != null){
            System.out.print(head.val + "  ");
            head = head.next;
        }
        System.out.println("-----");
    }

    private static ListNode solution(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode now = head;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                now.next = l1;
                l1 = l1.next;
            }
            else{
                now.next = l2;
                l2 = l2.next;
            }
            now = now.next;
        }
        while (l1 != null){
            now.next = l1;
            l1 = l1.next;
            now = now.next;
        }
        while (l2 != null){
            now.next = l2;
            l2 = l2.next;
            now = now.next;
        }
        return head.next;
    }

    private static void linked(ListNode l1,int n) {
        Scanner in = new Scanner(System.in);
//        for (int i = 0; i < 3; i++) {
//            int number = in.nextInt();
//            l1.next = new ListNode(number);
//            l1 = l1.next;
//        }
        for (int i = 1; i < 3 ; i++) {
            l1.next = new ListNode(i * n);
            l1 = l1.next;
        }
    }
}
