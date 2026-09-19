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
    public int maxAncestorDiff(TreeNode root) {
        return solve(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private int solve(TreeNode root, int minm, int maxm){
        if(root == null) return Math.abs(maxm - minm);
        if( root.val < minm ){
            minm = root.val;
        }
        if(root.val > maxm ){
            maxm = root.val;
        }
        return Math.max(solve(root.left,minm,maxm),solve(root.right,minm,maxm));
    }


}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna