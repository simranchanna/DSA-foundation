import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode forw = curr.next; //backup
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode h1 = reverse(l1);
        ListNode h2 = reverse(l2);
        ListNode dummy = new ListNode(-1);
        ListNode curr =  dummy;
        int carry = 0;
        while(h1 != null && h2 != null){
            int val = h1.val + h2.val + carry;
            carry = val / 10;
            val = val % 10;
            curr.next = new ListNode(val);
            curr = curr.next;
            h1 = h1.next;
            h2 = h2.next;
        }
        while(h1 != null){
            int val = h1.val + carry;
            carry = val / 10;
            val = val % 10;
            curr.next = new ListNode(val);
            curr = curr.next;
            h1 = h1.next;
        }
        while(h2 != null){
            int val = h2.val + carry;
            carry = val / 10;
            val = val % 10;
            curr.next = new ListNode(val);
            curr = curr.next;
            h2 = h2.next;
        }
        if(carry != 0){
            curr.next = new ListNode(carry);
            curr = curr.next;
        }
        return reverse(dummy.next);
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = addTwoNumbers(head1, head2);
        printList(ans);
    }

}