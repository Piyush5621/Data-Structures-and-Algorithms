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
    public ListNode removeNodes(ListNode head) {
        if(head == null || head.next == null ) return head;
        ListNode rev = reverse(head);
        ListNode dummy = new ListNode(rev.val);
        ListNode ans = dummy;
        int maxm = rev.val;
        ListNode temp = rev.next;

        while( temp != null){
            if(temp.val >= maxm){
                dummy.next = new ListNode(temp.val);
                maxm = temp.val;
                dummy = dummy.next;
            }
            temp = temp.next;
        }

        ListNode revans = reverse(ans);
        return revans;
       
    }

    private ListNode reverse(ListNode node){
        ListNode curr = node;
        ListNode prev = null;
        while(curr != null ){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr ;
            curr = nextNode;
        }
        return prev;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna