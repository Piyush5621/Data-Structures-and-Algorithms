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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head == null || head.next==null) return head;

        ListNode curr = head;
        int n =0;
        ListNode prev = null;
        while(curr!=null){
            n++;
            prev = curr;
            curr= curr.next;
        }
        k = k%n;
        prev.next = head;
        int t = n-k+1;
        curr = head;
        int i=1;
        ListNode ans = null;
        while(i++<t){
            ans =curr;
            curr =curr.next;
        }
        ans.next=null;
        return curr;
    }
}