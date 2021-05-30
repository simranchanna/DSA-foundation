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

    public static ListNode segregate(ListNode head, int pivotIdx) {
        if(head == null || head.next == null)
            return head;
        ListNode pivot = head;
        while(pivotIdx-- > 0){
            pivot = pivot.next;
        }
        ListNode l1 = new ListNode(-1), l2 = new ListNode(-1);
        ListNode sp = l1, lp = l2;
        ListNode curr = head;
        while(curr != null){
            if(curr != pivot && curr.val <= pivot.val){
                sp.next = curr;
                sp = curr;
            }
            else if(curr != pivot){
                lp.next = curr;
                lp = curr;
            }
            curr = curr.next;
        }
        sp.next = pivot;
        pivot.next = l2.next;
        lp.next = null;

        head = l1.next;
        return head;
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
    int idx = scn.nextInt();
    h1 = segregate(h1, idx);
    printList(h1);
  }
}