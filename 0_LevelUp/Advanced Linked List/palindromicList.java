import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode midNode(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode mid = midNode(head);
        ListNode c2 = reverse(mid.next);
        ListNode c1 = head;
        while(c2 != null){
            if(c1.val != c2.val)
                return false;
            c1 = c1.next;
            c2 = c2.next;    
        }      
        return true;
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

        System.out.println(isPalindrome(dummy.next));
    }
}