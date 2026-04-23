class Solution {
    int count = 0;
    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();
        backT(new StringBuilder(s),set);
        return count;
    }

    void backT(StringBuilder str,HashSet<String> set){
      
        for(int i=0; i<str.length(); i++){
            String s = str.substring(0,i+1);
            if(!set.contains(s)){
                set.add(s);
                str.delete(0, i+1);
                count = Math.max(count,set.size());
                backT(str,set);
                set.remove(s);
                str.insert(0,s);
            }
        }
    }
}

// 2nd 
class Solution {
    int ans = 0;
    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();
        backT(0,s,set);
        return ans;
    }

    void backT(int idx,String s,HashSet<String> set){
        if(set.size() + (s.length() - idx) <= ans) return;

        if(idx == s.length()){
            ans = Math.max(ans,set.size());
            return;
        }
        for(int i=idx; i<s.length(); i++){
            String word = s.substring(idx,i+1);
            if(!set.contains(word)){
                set.add(word);
                backT(i+1,s,set);
                set.remove(word);
            }
        }
    }
}