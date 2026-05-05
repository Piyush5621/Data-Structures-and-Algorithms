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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int ans [][]= new int[m][n];
        for(int a[]: ans) Arrays.fill(a,-1);
        ListNode curr = head;
        int left=0;
        int top=0;
        int right = n-1;
        int bottom = m-1;

        while(left<=right && top<=bottom){
            if(curr==null) break;
            for(int i=left;i<=right;i++){
                if(curr==null) break;
                ans[top][i]=curr.val;
                curr= curr.next;
            }
            top++;

            for(int i=top;i<=bottom;i++){
               if(curr==null) break;
                ans[i][right]=curr.val;
                curr= curr.next;
            }
            right--;

            for(int i=right;i>=left;i--){
                if(curr==null) break;
                ans[bottom][i]=curr.val;
                curr= curr.next;
            }
            bottom--;
            for(int i=bottom;i>=top;i--){
                if(curr==null) break;
                ans[i][left]=curr.val;
                curr= curr.next;
            }
            left++;
        }

        return ans;
    }
}