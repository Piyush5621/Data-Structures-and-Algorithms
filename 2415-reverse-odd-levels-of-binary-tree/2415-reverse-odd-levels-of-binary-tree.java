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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null) return root;
        solve(1,root.left,root.right);
        return root;
    }

    private void solve(int lvl, TreeNode root1, TreeNode root2){
        if(root1==null || root2==null) return;

        if(lvl%2!=0){
            int temp = root1.val;
            root1.val = root2.val;
            root2.val = temp;
        }

        solve(lvl+1, root1.left,root2.right);
        solve(lvl+1,root1.right,root2.left);
    }
}