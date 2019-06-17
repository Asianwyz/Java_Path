package Lettcode.let;

public class num24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head = solution(head);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static ListNode solution(ListNode head) {
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode last = prehead;
        while (head != null){
            if (head.next == null)
                break;
            last.next = head.next;
            head.next = head.next.next;
            last.next.next = head;
            last = head;
            head = last.next;
        }
        return prehead.next;
    }
}
