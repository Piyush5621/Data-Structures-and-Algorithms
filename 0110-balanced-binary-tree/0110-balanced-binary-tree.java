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
    private int height(TreeNode node ){
        if( node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        return 1 + Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        if( root == null ) return true;

        int left = height(root.left);
        int right = height(root.right);

        return (Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right)); 
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna