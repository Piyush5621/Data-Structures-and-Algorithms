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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<descriptions.length;i++){
            int par = descriptions[i][0];
            int child = descriptions[i][1];
            if(!set.contains(child)) set.add(child);
            map.putIfAbsent(par, new TreeNode(par));
            map.putIfAbsent(child, new TreeNode(child));

            if(descriptions[i][2]==1){
                map.get(par).left = map.get(child);
            }
            else{
                map.get(par).right = map.get(child);
            }
        }
        int parent = 0;
        for(int i=0;i<descriptions.length;i++){
            if(!set.contains(descriptions[i][0])){
                parent=descriptions[i][0];
                break;
            }
        }

        return map.get(parent);
    }
}