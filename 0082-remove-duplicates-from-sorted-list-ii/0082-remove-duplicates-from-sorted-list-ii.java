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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode ans = dummy;

        ListNode slow = dummy.next;
        ListNode second = dummy.next.next;

        ListNode prev = dummy;

        while(slow!=null && second!=null){
            boolean exist = false;
            while(second != null && slow.val == second.val){
                second = second.next;
                exist = true;
            }
            if(exist){
                prev.next = second;
                slow = second;
                second = (slow == null) ? null : slow.next;
                
            }
            else{
                prev= slow;
                slow = slow.next;
                second = second.next;
            }
            
        }

        return ans.next;
    }
}