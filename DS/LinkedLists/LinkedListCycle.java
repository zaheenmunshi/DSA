package DS.Linked-Lists;
import DS.Linked-Lists.Helper.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return false;

        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while(fast!=null && fast.next!=null){
            if(fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
