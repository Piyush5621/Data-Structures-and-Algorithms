class Solution {
    class TrieNode {
        TrieNode child[];
        boolean isEnd;
        TrieNode(){
            child = new TrieNode[26];
        }
    }
    TrieNode root = new TrieNode();

    void insert(String word){
        TrieNode  curr = root;
        for(int i=0;i<word.length(); i++){
            int idx = word.charAt(i)-'a'; 
            if(curr.child[idx]==null){
                curr.child[idx] = new TrieNode(); 
            }
            curr = curr.child[idx];
        }
        curr.isEnd = true;
    }
    boolean search(String key){
        TrieNode curr = root;
        for(int i=0; i<key.length(); i++){
            int idx = key.charAt(i) -'a';
            curr = curr.child[idx];
            if(curr.isEnd==false){
                return false;
            }
        }
        return true;
    }
    public String longestWord(String[] words) {
        for(String s : words){
            insert(s);
        }

        StringBuilder ans = new StringBuilder();
        for(String s : words){
            if(search(s)){
                if(ans.length()<s.length()){
                    ans.replace(0,ans.length(),s);
                }
                else if(ans.length()==s.length() && s.compareTo(ans.toString()) < 0){
                    ans.replace(0,ans.length(),s);
                }
            }
        }
        return ans.toString();
    }
}