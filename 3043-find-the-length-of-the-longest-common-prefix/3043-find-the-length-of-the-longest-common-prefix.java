class Solution {
    class TrieNode{
        TrieNode child[];
        boolean isEnd;
        TrieNode(){
            child = new TrieNode[10];
        }
    }
    TrieNode root = new TrieNode();

    void insert(int num){
        TrieNode curr = root;
        String word = String.valueOf(num);
        for(int i=-0;i<word.length();i++){
            int d = word.charAt(i)-'0';
            if(curr.child[d]==null){
                curr.child[d] = new TrieNode();
            }
            curr=curr.child[d];
        }
        curr.isEnd = true;
    }

    int search(int num){
        int c =0;
        TrieNode curr = root;
        String word = String.valueOf(num);
        for(int i=-0;i<word.length();i++){
            int d = word.charAt(i)-'0';
            if(curr.child[d]==null){
                return c;
            }
            curr=curr.child[d];
            c++;
        }
        return c;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        for(int x : arr2){
            insert(x);
        }
        int ans = 0;
        for(int x : arr1){
            ans = Math.max(ans,search(x));
        }
        return ans;
    }
}