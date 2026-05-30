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
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder temp = new StringBuilder();
        List<String> ans = new ArrayList<>();
        solve(root,temp,ans);
        return ans;
    }

    void solve(TreeNode root, StringBuilder temp, List<String> ans){
        if(root==null) return;
        int t = temp.length(); 
        String s = String.valueOf(root.val);
        temp.append(s);
        if(root.left == null && root.right == null){
            ans.add(temp.toString());
        }
        temp.append("->");
        solve(root.left,temp,ans);
        solve(root.right,temp,ans);
        temp.setLength(t);
    }
}