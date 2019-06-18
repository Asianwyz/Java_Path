package Lettcode.let;

public class num25 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        head = solution(head,k);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static ListNode solution(ListNode head, int k) {
        if (k == 1)
            return head;
        int count = 0;
        ListNode flag = new ListNode(0);
        flag.next = head;
        ListNode prehead = flag;
        while (head != null) {
            count++;
            if (count == k) {
                head = reverse(prehead, k);
                prehead = head;
                count = 0;
            }
            head = head.next;
        }
        return flag.next;
    }

    private static ListNode reverse(ListNode prehead, int k) {
        ListNode now = prehead.next;
        ListNode next = now.next;
        int times = 1;
        while (times < k){
            ListNode swap = next.next;
            next.next = now;
            now = next;
            next = swap;
            times++;
        }
        ListNode tail = prehead.next;
        prehead.next.next = next;
        prehead.next = now;
        return tail;
    }
}
