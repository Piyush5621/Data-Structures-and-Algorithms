class Trie {
    class TrieNode{
        TrieNode child[];
        boolean isEnd;
        TrieNode(){
            child = new TrieNode[26];
            isEnd = false; 
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(curr.child[idx]==null){
                curr.child[idx] = new TrieNode();
            }
            curr = curr.child[idx];
        }
        curr.isEnd=true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(curr.child[idx]==null) return false;
            curr = curr.child[idx];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        int c = 0;
        int n = prefix.length();
        for(int i = 0; i<n; i++){
            int idx = prefix.charAt(i)-'a';
            if(curr.child[idx]==null && c<n){
                return false;
            }
            curr = curr.child[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */