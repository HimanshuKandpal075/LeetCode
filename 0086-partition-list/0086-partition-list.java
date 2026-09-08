/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode lessHead = new ListNode(0);
        ListNode lessTail = lessHead;
        
        ListNode moreHead = new ListNode(0);
        ListNode moreTail = moreHead;

        ListNode curr = head;

        while(curr != null){
            if(curr.val < x){
                lessTail.next = curr;
                lessTail = lessTail.next;
            }
            else{
                moreTail.next = curr;
                moreTail = moreTail.next;
            }
            curr = curr.next;
        }

        lessTail.next = moreHead.next;
        moreTail.next = null;

        return lessHead.next;
    }
}


