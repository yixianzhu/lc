//my correct solution
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode move = head;
        if(head == null) return head;
        while(move.next != null){
            while(move.val == move.next.val){
                move.next = move.next.next;
                if(move.next == null) return head;
            }
            move = move.next;
        }
        return head;
    }
}

//other simple solution
//use less space than me 
public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
}

