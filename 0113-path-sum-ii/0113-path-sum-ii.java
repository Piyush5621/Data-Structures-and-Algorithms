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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(root,targetSum,ans,temp);
        return ans;
    }

    void solve(TreeNode root, int ts,List<List<Integer>> ans,List<Integer>temp){
        if(root==null) return;
        
        temp.add(root.val);
        ts-=root.val;
        if(root.left==null && root.right==null){
            if(ts==0){
                ans.add(new ArrayList<>(temp));
            }
        }

        solve(root.left,ts,ans,temp);
        solve(root.right,ts,ans,temp);
        temp.remove(temp.size()-1);
    }

}