class WordDictionary {
    class TrieNode {
        TrieNode[] child;
        boolean isEnd;

        TrieNode() {
            child = new TrieNode[26];
            isEnd = false;
        }
    }
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.child[idx]==null){
                curr.child[idx]=new TrieNode();
            }
            curr = curr.child[idx];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return helper(word,0,root);
    }

    public boolean helper(String word,int idx,TrieNode curr){

        if(curr == null) return false;

        if(idx == word.length()) return curr.isEnd;

        char c = word.charAt(idx);

        if(c=='.'){
            for(int i=0;i<26;i++){
                if(curr.child[i]!=null && helper(word,idx+1,curr.child[i])){
                    return true;
                }
            }
            return false;
        }
        else{
            return helper(word,idx+1,curr.child[c-'a']);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */