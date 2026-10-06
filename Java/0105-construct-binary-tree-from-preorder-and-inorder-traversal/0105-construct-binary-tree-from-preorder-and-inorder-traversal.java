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
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for( int i = 0 ; i < inorder.length; i++ ){
            map.put(inorder[i], i);
        }
        return solve(preorder,inorder,0,inorder.length-1);
    }
    private TreeNode solve(int pre[], int in[], int s, int e){
        if( s > e){
            return null;
        }
        int idx = map.get(pre[preIdx]);
        TreeNode node = new TreeNode(pre[preIdx]);
        preIdx++;

        node.left = solve(pre,in,s,idx-1);
        node.right = solve(pre,in,idx+1,e);

        return node;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna