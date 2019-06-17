package Lettcode.let;

public class num02 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);
        ListNode head = add(l1,l2);
        while (head != null){
            System.out.print(head.val);
            head = head.next;
        }
    }

    private static ListNode add(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(0);
        ListNode add = prehead;
        int count = 0;
        while (l1 != null && l2 != null){
            int num = l1.val + l2.val + count;
            if (num > 9){
                count = 1;
                num %= 10;
            }
            else count = 0;
            ListNode node = new ListNode(num);
            add.next = node;
            add = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        add.next = l1 == null ? l2 : l1;
        while (count == 1 && add.next != null){
            add = add.next;
            add.val += 1;
            if (add.val > 9){
                add.val %= 10;
            }
            else count = 0;
        }
        if (count == 1)
            add.next = new ListNode(1);
        return prehead.next;
    }
}
