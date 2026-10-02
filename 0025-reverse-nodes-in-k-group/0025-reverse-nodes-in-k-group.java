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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode groupprev = dummy;


        while( true ){
            ListNode curr = groupprev;

            for(int i =0 ; i < k ; i++ ){
                curr = curr.next;
                if(curr == null) return dummy.next;
            }

            ListNode groupNext = curr.next;
            ListNode prev = curr.next;
            ListNode currGroup = groupprev.next;

            while( currGroup != groupNext ){
                ListNode nextNode = currGroup.next;
                currGroup.next = prev;
                prev = currGroup;
                currGroup = nextNode;
            } 

            ListNode temp = groupprev.next;
            groupprev.next = curr;
            groupprev = temp;

        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna