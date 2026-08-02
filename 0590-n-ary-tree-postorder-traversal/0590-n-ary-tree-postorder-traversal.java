/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        solve(root,ans);
        return ans;
    }
    private void solve(Node root,List<Integer> ans){
        if(root==null) return ;

        for(Node curr : root.children){
            solve(curr,ans);
        }
        ans.add(root.val);
    }
}