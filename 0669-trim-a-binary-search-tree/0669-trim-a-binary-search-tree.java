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
    public TreeNode insert(TreeNode node,int x){
        if(node==null){
            node = new TreeNode(x);
            return node;
        }

        if(node.val <  x){
            node.right = insert(node.right,x);
        }
        else{
            node.left = insert(node.left ,x);
        }

        return node;

    } 
    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode node = null;
        node = search(root,node,low,high);
        return node;
    }

    public TreeNode search(TreeNode root,TreeNode node, int low, int high){
        if(root==null) return node;

        if(root.val>=low && root.val<=high){
            node = insert(node, root.val);
        }
        node = search(root.left,node,low,high);
        node = search(root.right,node,low,high);
        return node;
    }
}