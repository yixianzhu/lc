/*
Local variables do not get default values. 
Their initial values are undefined with out assigning values by some means. 
Before you can use local variables they must be initialized.

There is a big difference when you declare a variable 
at class level (as a member ie. as a field) and at method level.

If you declare a field at class level they get default values according to their type. 
If you declare a variable at method level or as a block (means anycode inside {}) 
do not get any values and remain undefined 
until somehow they get some starting values ie some values assigned to them.
*/

//correct solution
//use recursion might actually not satisfy the O(1) space complexity requirement (useing stack)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode h; // should be put here
    public boolean isPalindrome(ListNode head) {
        //ListNode h;   should not put it here cause it requires initialization and will be renewed in every recursion
        if(head == null) return true;
        if(h == null) h=head;
        
        boolean temp = true;
        if(head.next != null) temp &= isPalindrome(head.next);
        
        temp &= (h.val == head.val);
        h=h.next;
        return temp;
    }
}


//other solution without using recursion but changint the original data
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = p1.next;
        ListNode pre = p1;
        //find mid pointer, and reverse head half part
        while(p2.next != null && p2.next.next != null) {
            p2 = p2.next.next;
            pre = p1;
            p1 = p3;
            p3 = p3.next;
            p1.next = pre;
        }

        //odd number of elements, need left move p1 one step
        if(p2.next == null) {
            p1 = p1.next;
        }
        else {   //even number of elements, do nothing

        }
        //compare from mid to head/tail
        while(p3 != null) {
            if(p1.val != p3.val) {
                return false;
            }
            p1 = p1.next;
            p3 = p3.next;
        }
        return true;

    }
}
