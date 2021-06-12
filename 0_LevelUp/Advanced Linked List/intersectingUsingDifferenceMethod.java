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
    public static int length(ListNode head){
        ListNode node = head;
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        return len;
    }
    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        int lenA = length(headA);
        int lenB = length(headB);
        int diff = Math.max(lenA, lenB) - Math.min(lenA, lenB);
        ListNode bigger = lenA > lenB ? headA : headB;
        ListNode smaller = lenB < lenA ? headB : headA;
        while(diff-- > 0)
            bigger = bigger.next;
        while(bigger != smaller){
            bigger = bigger.next;
            smaller = smaller.next;
        }    
        return bigger;
    }

    // Input_code===================================================

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

        int idx = scn.nextInt();

        ListNode head2 = makeList(scn.nextInt());

        if (idx >= 0) {
            ListNode curr = head1;
            while (idx-- > 0)
                curr = curr.next;

            ListNode prev = head2;
            while (prev.next != null)
                prev = prev.next;

            prev.next = curr;
        }

        ListNode ans = IntersectionNodeInTwoLL(head1, head2);
        System.out.println(ans != null ? ans.val : -1);
    }
}