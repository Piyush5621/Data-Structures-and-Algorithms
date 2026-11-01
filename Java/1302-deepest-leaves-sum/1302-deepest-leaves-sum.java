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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int curr=0;

        while( !q.isEmpty() ) {
            int size = q.size();
            curr  = 0;
            for( int i = 0; i < size ; i++ ){
                TreeNode nodes = q.poll();
                curr += nodes.val;

                if(nodes.left != null ) q.offer(nodes.left);
                if(nodes.right != null ) q.offer(nodes.right);
            }
        }

        return curr;

    }
}