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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();

        q.add(root);
        boolean even = true;
        while(!q.isEmpty()){
            int size = q.size();
            int prev;
            if(even) prev = Integer.MIN_VALUE;
            else prev = Integer.MAX_VALUE;
            for(int i =0 ;i <size; i++){
                TreeNode curr = q.poll();
                if(even){
                    if( curr.val % 2 ==0 || prev >= curr.val ){
                        return false;
                    }
                    prev = curr.val; 
                }
                else{
                    if(curr.val % 2 !=0 || prev <= curr.val){
                        return false;
                    }
                    prev = curr.val;
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(even) even = false;
            else even = true;
        }

        return true;
    }
}