// iterative solution

public ListNode reverseList(ListNode head) {
    ListNode newHead = null;
    while(head != null){
        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;
    }
    return newHead;//should return newHead
}


//iterate
public ListNode reverseList(ListNode head) {
    ListNode first = null;
    ListNode tail = head;
    while (tail != null) {
        ListNode tmp = tail;
        tail = tail.next;
        tmp.next = first;
        first = tmp;
    }
    return first;
}

// Recursion:
public ListNode reverseList(ListNode head) {
    return helper(null, head);
}

ListNode helper(ListNode reversed, ListNode remaining) {
    if(remaining==null) return reversed;
    ListNode tmp = remaining.next;
    remaining.next = reversed;

    return helper(remaining, tmp);
}

// Iteration:
public ListNode reverseList(ListNode head) {
    if(head==null) return head;

    ListNode newhead = new ListNode(0);
    newhead.next = head;

    while(head.next!=null) {
        ListNode tmp = head.next;
        head.next = head.next.next;

        tmp.next = newhead.next;
        newhead.next = tmp;
    }
    return newhead.next;
}
