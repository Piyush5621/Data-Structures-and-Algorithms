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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        solve(root);
        return root;
    }
    TreeNode solve(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode Lst=solve(root.left);
        TreeNode Rst=solve(root.right);
        root.left=Rst;
        root.right=Lst;
        return root;
    }
}