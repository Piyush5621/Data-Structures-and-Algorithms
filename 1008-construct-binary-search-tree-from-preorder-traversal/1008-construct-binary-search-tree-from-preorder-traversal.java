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
    int preIdx = 0;
    TreeNode buildTree(int preorder[] , int minVal, int maxVal){
        if(preIdx == preorder.length) return null;
        int rootVal = preorder[preIdx];

        if(rootVal < minVal || rootVal > maxVal) return null;

        preIdx++;
        TreeNode root= new TreeNode(rootVal);
        root.left = buildTree(preorder,minVal,rootVal);
        root.right = buildTree(preorder,rootVal,maxVal);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}