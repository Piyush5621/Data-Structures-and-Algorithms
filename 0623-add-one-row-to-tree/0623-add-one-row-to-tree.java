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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root==null) return null;

        if(depth == 1){
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }

        dfs(root,1,depth,val);

        return root;
    }

    void dfs(TreeNode node, int currH, int depth, int val){
        if(node==null) return;

        if(currH == depth-1){
            TreeNode ol = node.left;
            TreeNode or = node.right;
            node.left = new TreeNode(val);
            node.right = new TreeNode(val);
            node.left.left = ol;
            node.right.right = or;
        }

        dfs(node.left,currH+1,depth,val);
        dfs(node.right,currH+1,depth,val);
    }
}