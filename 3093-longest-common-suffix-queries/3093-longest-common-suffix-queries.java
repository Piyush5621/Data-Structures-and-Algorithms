class Solution {
    class Trie{
        Trie child[];
        int index;
        Trie(){
            child = new Trie[26];
            index=-1;
        }
    }

    Trie root = new Trie();
    boolean best(String[] Wc,int i,int j){
        if(j==-1) return true;
        else if(Wc[i].length() < Wc[j].length()) return true;
        else if(Wc[i].length() == Wc[j].length()) return i<j;
        return false;
    }
    void insert(int idx, String word, String[] Wc){
        Trie curr = root;
        if(best(Wc,idx,curr.index)){
            curr.index = idx;
        }

        for(int i=word.length()-1; i>=0; i--){
            int j = word.charAt(i)-'a';
            if(curr.child[j]==null){
                curr.child[j]=new Trie();
            }
            curr = curr.child[j];
            if(best(Wc,idx,curr.index)){
                curr.index=idx;
            }
        }
    }

    int search(String word){
        Trie curr = root;
        for(int i=word.length()-1; i>=0; i--){
            int idx = word.charAt(i)-'a';
            if(curr.child[idx]==null){
                return curr.index;
            }
            curr=curr.child[idx];
        }
        return curr.index;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int n = wordsContainer.length;
        for(int i=0; i<n; i++){
            insert(i,wordsContainer[i],wordsContainer);
        }
        int m = wordsQuery.length;
        int ans[] = new int[m];
        for(int i=0;i<m;i++){
            ans[i] = search(wordsQuery[i]);
        } 
        return ans;
    }
}