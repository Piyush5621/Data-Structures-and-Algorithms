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
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverse(slow);
        int maxSum = 0;
        ListNode firstHalf = head;
        while (secondHalf != null) {
            maxSum = Math.max(maxSum,firstHalf.val + secondHalf.val);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return maxSum;
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