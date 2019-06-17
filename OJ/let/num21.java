package Lettcode.let;

public class num21 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode now = head;
        while (l1 != null && l2 != null){
            int val1 = l1.val;
            int val2 = l2.val;
            if (val1 < val2){
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
}
