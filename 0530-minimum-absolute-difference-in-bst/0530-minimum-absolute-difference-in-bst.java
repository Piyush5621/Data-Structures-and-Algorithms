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

    int prev = -1;
    int res = Integer.MAX_VALUE;
    private void solve(TreeNode root){
        if(root==null) return ;
        solve(root.left);
        if(prev!=-1) res= Math.min(res, root.val- prev);
        prev = root.val;
        solve(root.right);
    }
    public int getMinimumDifference(TreeNode root) {


        solve(root);
        return res;

    }
}