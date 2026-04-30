class Solution {
    String[] map = {
            "",  
            "",     
            "abc",  
            "def",  
            "ghi", 
            "jkl",  
            "mno",  
            "pqrs", 
            "tuv",  
            "wxyz" 
    };
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        pad(new StringBuilder(),digits,ans,digits.length());
        return ans;
    }
    void pad(StringBuilder temp,String str,List<String> ans,int n){
        if(temp.length()==n){
            ans.add(temp.toString());
            return;
        }
        int d=str.charAt(0)-'0';
        String s=map[d];
        for(char c:s.toCharArray()){
            temp.append(c);
            pad(temp,str.substring(1),ans,n);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}