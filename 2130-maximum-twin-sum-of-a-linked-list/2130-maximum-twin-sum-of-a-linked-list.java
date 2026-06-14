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
    public int pairSum(ListNode head) {
        ListNode temp1 = head;
        ListNode slow = head;
        ListNode fast = head;
        while( fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode curr1 = reverse(slow);
        int maxm = 0;
        while( temp1!=null && curr1!=null ){
            int sum = temp1.val +curr1.val;
            maxm = Math.max(maxm,sum);
            temp1=temp1.next;
            curr1=curr1.next;
        }
        return maxm;
    }

    ListNode reverse(ListNode node){
        ListNode prev =null;
        while(node!=null){
            ListNode nextNode = node.next;
            node.next = prev;
            prev = node;
            node = nextNode; 
        }
        return prev;
    }
}