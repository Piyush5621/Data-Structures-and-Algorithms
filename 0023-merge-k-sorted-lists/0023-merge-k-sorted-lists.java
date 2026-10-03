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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(ListNode temp : lists){
            if( temp != null ) pq.offer(temp);
        }

        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;

        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            dummy.next = node;
            dummy = dummy.next;
            if(node.next != null ){
                pq.offer(node.next);
            }
        }

        return ans.next;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna