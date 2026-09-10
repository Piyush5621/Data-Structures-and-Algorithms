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
    int ans;
    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        if (root == null)
            return 0;
        solve(root);
        return ans;
    }

    private int[] solve(TreeNode root) {
        if (root == null)
            return new int[]{0,0};

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        int count = 1 + left[1]+right[1];
        int currAvg = (root.val + left[0] + right[0]) / (count);
        if (root.val == currAvg) ans++;

        return new int[]{root.val + left[0]+right[0],count};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna