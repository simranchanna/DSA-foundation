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

    static ListNode th =  null, tt = null;
    public static void addFirstNode(ListNode node){
        if (th == null)
            th = tt = node;
        else {
            node.next = th;
            th = node;
        }
    }
    public ListNode reverseInRange(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right)
            return head;
        int idx = 1;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy, curr = head;
        prev.next = head;
        while(idx < left){                                         
            prev = prev.next;
            curr = curr.next;
            idx++;
        }
        while(idx <= right){
            ListNode forw = curr.next;
            curr.next = null;
            addFirstNode(curr);
            curr = forw;
            idx++;
        }
        prev.next = th;
        tt.next = curr;
        return dummy.next;
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
        int sz = scn.nextInt();
        ListNode h1 = createList(sz);

        int m = scn.nextInt();
        int n = scn.nextInt();

        h1 = reverseInRange(h1, m, n);
        printList(h1);
    }
}