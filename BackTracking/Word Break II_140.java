class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        solve(wordDict,s,ans,new StringBuilder());
        return ans; 
    }
    void solve(List<String> wordDict,String s,List<String> ans,StringBuilder str){
        if(s.length()==0){
            ans.add(str.toString());
            return;
        }
        for(int i=0;i<wordDict.size();i++){
            String word = wordDict.get(i);
            if(s.startsWith(word)){
                int len = str.length();
                if(str.length()!=0) str.append(" ");
                str.append(word); 
                solve(wordDict,s.substring(word.length()),ans,str);
                str.setLength(len);
            }
        }
    }
}