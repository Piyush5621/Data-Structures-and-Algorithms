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
    class Pair{
        TreeNode node;
        int lvl;
        Pair(TreeNode a, int b){
            node = a;
            lvl = b;
        }
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int lvl =0;

        while(!q.isEmpty()){

            int size = q.size();

            ArrayList<TreeNode> list = new ArrayList<>();
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();
                list.add(curr);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right !=null) q.add(curr.right);
            }
            if( lvl%2 != 0){
                int i =0;
                int e = list.size()-1;
                while(i < e){
                    int temp = list.get(i).val;
                    list.get(i).val = list.get(e).val;
                    list.get(e).val = temp;
                    i++;
                    e--;
                }
            }
            lvl++;
        }

        return root;

    }
}