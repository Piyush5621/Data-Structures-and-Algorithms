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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        int arr [] = new int[]{-1,-1};
        int first = -1;
        int prevLast = -1;
        int i =1;
        while(curr != null && curr.next != null){
            if(prev != null){
                if((prev.val < curr.val && curr.val > curr.next.val) || (prev.val > curr.val && curr.val < curr.next.val)){
                    if(first == -1){
                        first = i; 
                        prevLast = i; 
                    }
                    else{
                        arr[0] = Math.min((arr[0]==-1)? Integer.MAX_VALUE : arr[0],i - prevLast);
                        arr[1] = i - first;
                        prevLast = i;
                    }
                }
            }
            i++;
            prev = curr;
            curr = curr.next;
        }

        return arr;
    }
}