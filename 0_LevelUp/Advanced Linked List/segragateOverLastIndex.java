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

    public static ListNode segregateOnLastIndex(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        ListNode pivot = curr;
        ListNode l1 = new ListNode(-1), l2 = new ListNode(-1);
        ListNode smaller = l1, bigger = l2;
        curr = head;
        while(curr != null){
            if(curr.val < pivot.val){
                smaller.next = curr;
                smaller = curr;
            }
            else if(curr.val > pivot.val){
                bigger.next = curr;
                bigger = curr;
            }
            curr = curr.next;
        }
        smaller.next = pivot;
        pivot.next = l2.next;
        bigger.next = null;
        return pivot;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);
        h1 = segregateOnLastIndex(h1);
        printList(h1);
    }
}