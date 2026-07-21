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
    private TreeNode solve(int[] preorder, int[] inorder, int low, int high, HashMap<Integer,Integer> map){
        if(low > high){
            return null;
        }
        TreeNode curr = new TreeNode(preorder[preIdx]);
        int idx = map.get(preorder[preIdx]);
        preIdx++;
        curr.left =  solve(preorder, inorder, low, idx-1,map);
        curr.right = solve(preorder, inorder, idx+1, high,map);
        return curr;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i] , i);
        }
        return solve(preorder, inorder, 0 , inorder.length-1, map);
    }
}