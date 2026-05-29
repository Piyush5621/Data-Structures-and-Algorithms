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
    public TreeNode solve(int []pre, int in[],int i,int e){
        if(i>e) return null;
        TreeNode curr = new TreeNode(pre[preIdx++]);
        int idx=0;
        for(int j=i;j<=e;j++){
            if(in[j]==curr.val){
                idx = j;
                break;
            }
        }
        curr.left = solve(pre,in,i,idx-1);
        curr.right = solve(pre,in,idx+1,e);
        return curr;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder,inorder,0,preorder.length-1);
    }
}