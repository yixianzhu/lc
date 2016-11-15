
if (list.size()) < 3) {
    return null;
} else {
    ListNode pre = head.next.next;
    ListNode cur = pre.next;
    ListNode head = cur;
    int fib1 = 2; //3
    int fib2 = 3; //5
    int fib3 = 5; //8
    int count = 4;
    while (cur.hasNext()) {
        if(count == fib3) {
            count++; //9
            pre.next = cur.next; //pre 7
            cur = cur.next; // cur 9
            int temp = fib2+fib3;
            fib1 = fib2;
            fib2 = fib3;
            fib3 = temp;
        } else {
            count++; //8
            pre = pre.next; //7th
            cur = cur.next; //8th
        }
    }
    
    return head;
}
