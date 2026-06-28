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
    int h = -1;
    public int findBottomLeftValue(TreeNode root) {
        solve(root,0,true);
        return ans;
    }

    public void solve(TreeNode root, int height,boolean isLeft){
        if(root==null)  return;
        if((root.left==null || root.right==null) ){
            if(h < height ){
                ans = root.val;
                h = height;
            }
        }
        solve(root.left, height+1, true);
        solve(root.right, height+1, false);
    }
}