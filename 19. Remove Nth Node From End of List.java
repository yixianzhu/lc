//my wrong solution
//--when n equals the size of the linked list, it will have NullPointerException
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        
        for(int i=0; i<n; i++){
            fast = fast.next;
        }
        
        while(fast.next != null){
        // while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return head;
    }
    
//correct solution
//Since the question gives that n is valid, not too many checks have to be put in place. Otherwise, this would be necessary.
public ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode start = new ListNode(0);
    ListNode slow = start, fast = start;
    slow.next = head;

    //Move fast in front so that the gap between slow and fast becomes n
    for(int i=1; i<=n+1; i++)   {
        fast = fast.next;
    }
    //Move fast to the end, maintaining the gap
    while(fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    //Skip the desired node
    slow.next = slow.next.next;
    return start.next;
}
