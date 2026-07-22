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
    private TreeNode solve(int i, int n, int preorder[],int postorder[],HashMap<Integer,Integer>premap, HashMap<Integer,Integer> postmap){
        if (i > n) return null;
        TreeNode root = new TreeNode (preorder[i]);
        if (i == n) return root;
        int m = premap.get(postorder[postmap.get(preorder[i]) - 1]);
        root.left = solve (i + 1, m - 1, preorder,postorder,premap,postmap);
        root.right = solve (m, n, preorder,postorder,premap,postmap);
        return root;

    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer> premap = new HashMap<>();
        HashMap<Integer,Integer> postmap = new HashMap<>();
        int n = preorder.length;
        for( int i = 0; i < n ; i++){
            premap.put(preorder[i],i);
        } 
        for( int i = 0; i < n ; i++){
            postmap.put(postorder[i],i);
        } 

        return solve(0, n - 1, preorder,postorder,premap,postmap);
    }
}