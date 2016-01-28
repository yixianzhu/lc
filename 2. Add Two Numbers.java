/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode sentinel = new ListNode(0);//this line: how to initiate
        ListNode sum = sentinel;//this line: how to set two pointers
        while(l1 != null || l2 != null){
            if(l1 == null){
                temp = l2.val + temp;
                l2 = l2.next;
                sum.next = new ListNode(temp%10);//this line: how to initiate!!!
                sum = sum.next;
                temp = temp/10;
            }else if(l2 == null){
                temp = l1.val + temp;
                l1 = l1.next;
                sum.next = new ListNode(temp%10);//this line: how to initiate!!!
                sum = sum.next;
                temp = temp/10;
            }else{
                temp = l1.val + l2.val + temp;
                l1 = l1.next;
                l2 = l2.next;
                sum.next = new ListNode(temp%10);//this line: how to initiate!!!
                sum = sum.next;
                temp = temp/10;
            }
        }
        
        if(temp != 0){
            sum.next = new ListNode(temp);//this line: how to initiate!!!
        }
        return sentinel.next;//should be next!!!
    }
}


//the correct solution I imitate
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }
}


//another answer which is more concise
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode result = head;
    int carry = 0;

    while (l1 != null || l2 != null || carry > 0) {
        int resVal = (l1 != null? l1.val : 0) + (l2 != null? l2.val : 0) + carry;
        result.next = new ListNode(resVal % 10);
        carry = resVal / 10;
        l1 = (l1 == null ? l1 : l1.next);
        l2 = (l2 == null ? l2 : l2.next);
        result = result.next;
    }

    return head.next;
}

