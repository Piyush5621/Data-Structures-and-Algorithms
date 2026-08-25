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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;

        ListNode curr1 = reverse(l1);
        ListNode curr2 = reverse(l2);
        int carry = 0;

        while(curr1!=null || curr2!=null || carry > 0){
            int sum = carry;

            if(curr1!=null){
                int x = curr1.val;
                sum += x;
                curr1 = curr1.next;
            }

            if(curr2!=null){
                int y = curr2.val;
                sum += y;
                curr2 = curr2.next;
            }

            int lastDig = sum%10;
            dummy.next = new ListNode(lastDig);
            dummy = dummy.next;
            carry = sum/10;
        }

        ListNode head = reverse(ans.next);

        return head;
    }

    private ListNode reverse(ListNode node){
        ListNode prev= null;
        ListNode curr = node;
        while(curr!=null){
            ListNode nextNode = curr.next;
            curr.next = prev; 
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}