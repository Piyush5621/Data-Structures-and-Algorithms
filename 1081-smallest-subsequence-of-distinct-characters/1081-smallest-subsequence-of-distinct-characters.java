class Solution {
    public String smallestSubsequence(String s) {
        int ans = 1;
        int lastOcc[] = new int[26];
        boolean visited[] = new boolean[26];

        for(int i = 0; i < s.length(); i++){
            lastOcc[s.charAt(i) - 'a'] = i;
        } 

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(visited[c-'a']){
                continue;
            }
            else{
                while(str.length()>0 && str.charAt(str.length()-1) > c && lastOcc[str.charAt(str.length()-1)-'a'] > i){
                    visited[str.charAt(str.length()-1)-'a']=false;
                    str.setLength(str.length()-1);
                }
                str.append(c);
                visited[c-'a'] = true;
            }
            
        }

        return str.toString();

    }
}