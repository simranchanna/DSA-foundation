import java.util.*;

class Main {
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
    public static void unfold(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);
        
        ListNode p1 = l1, p2 = l2;
        ListNode c1 = head, c2 = head.next;

        while(c1 != null  && c2 != null){
            p1.next = c1;
            p2.next = c2;
            p1 = p1.next;
            p2 = p2.next;
            if(c2 != null) c1 = c2.next;
            if(c1 != null) c2 = c1.next;
        }
        p1.next = null;
        ListNode nhead = reverse(l2.next);
        p1.next = nhead;
        
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}