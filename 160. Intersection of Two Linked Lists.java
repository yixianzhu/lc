
//my wrong solution
/*
why does recursion cause stackoverflow so much more than loops do?
Because each recursive call uses some space on the stack. 
If your recursion is too deep, then it will result in StackOverflow, 
depending upon the maximum allowed depth in the stack.

When using recursion, you should be very careful and make sure that you provide a base case. 
A base case in recursion is the condition based on which the recursion ends, and the stack starts to unwind. 
This is the major reason of recursion causing StackOverflow error. 
If it doesn't find any base case, it will go into an infinite recursion, 
which will certainly result in error, as Stack is finite only.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }else if(headA.val == headB.val){
            return headA;
        }else if(headA.val < headB.val){
            return getIntersectionNode(headA.next, headB);
        }else{
            return getIntersectionNode(headA, headB.next);
        }
    }
}


//correct solution -- without calculating the lengths
/*
How to prove: 
say A length = a + c, B length = b + c, 
after switching pointer, pointer A will move another b + c steps, pointer B will move a + c more steps, 
since a + c + b + c = b + c + a + c, it does not matter what value c is. 
Pointer A and B must meet after a + c + b (b + c + a) steps. If c == 0, they meet at NULL.
*/
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //boundary check
    if(headA == null || headB == null) return null;

    ListNode a = headA;
    ListNode b = headB;

    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
        //for the end of first iteration, we just reset the pointer to the head of another linkedlist
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }

    return a;
}


//correct solution -- need to calculate the lengths
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lenA = length(headA), lenB = length(headB);
    // move headA and headB to the same start point
    while (lenA > lenB) {
        headA = headA.next;
        lenA--;
    }
    while (lenA < lenB) {
        headB = headB.next;
        lenB--;
    }
    // find the intersection until end
    while (headA != headB) {
        headA = headA.next;
        headB = headB.next;
    }
    return headA;
}

private int length(ListNode node) {
    int length = 0;
    while (node != null) {
        node = node.next;
        length++;
    }
    return length;
}
