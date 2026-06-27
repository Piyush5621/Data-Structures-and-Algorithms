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
    int j=0;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();

        firstTree(root1,list);

        if(!secondTree(root2,list)) return false;

        return j==list.size();
    
    }

    public void firstTree(TreeNode root,List<Integer> list){
        if(root==null) return ;

        if(root.left==null && root.right==null){
            list.add(root.val);
        }
        firstTree(root.left,list);
        firstTree(root.right,list);
    }
    public boolean secondTree(TreeNode root,List<Integer> list){
        if(root==null) return true;
        if(root.left==null && root.right==null){
            if(j>=list.size()) return false;
            if(list.get(j)!=root.val) return false;
            else j++;
        }
        return secondTree(root.left,list) && secondTree(root.right,list);
        
    }
}