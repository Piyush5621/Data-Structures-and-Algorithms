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
    int ans = 0;
    int hMax = -1;
    public int findBottomLeftValue(TreeNode root) {
        solve(root, 0);
        return ans;
    }

    private void solve(TreeNode root,int h){
        if(root == null ) return;

        if( h > hMax ){
            hMax = h;
            ans = root.val;
        }

        solve(root.left , h+1);
        solve(root.right,h+1);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna