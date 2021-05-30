import java.util.*;

class Main {
  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static ListNode segregateEvenOdd(ListNode head) {
    if(head == null || head.next == null)
        return head;
    ListNode l1 = new ListNode(-1), l2 = new ListNode(-1);
    ListNode even = l1, odd = l2;
    ListNode curr = head;
    while(curr != null){
        if(curr.val % 2 == 0){
            even.next = curr;
            even = curr;
        }
        else{
            odd.next = curr;
            odd = curr;
        }
        curr = curr.next;
    }
    even.next = l2.next;
    odd.next = null;
    return l1.next;
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

    ListNode head = segregateEvenOdd(dummy.next);
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }
}