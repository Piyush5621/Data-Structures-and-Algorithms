/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int c =0;
    public int kthSmallest(TreeNode root, int k) {
        return solve(root, k);
    }
    private int solve( TreeNode root, int k ){
        if(root == null ) return -1;

        int result = solve(root.left , k );
        if( result != -1 ) return result;
        c++;
        if(c == k) return root.val;
        return solve(root.right, k);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna