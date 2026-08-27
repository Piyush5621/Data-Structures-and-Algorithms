class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int freq[] = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        String ans = solve(0,target,freq, new StringBuilder());
        return ans;
    }
    String solve(int idx , String target,int freq[], StringBuilder ans){
        if(idx >= target.length()) {
            return "";
        }
        char t = target.charAt(idx);
        if(freq[t-'a'] > 0){
            freq[t-'a']--;
            ans.append(t);

            String str = solve(idx+1, target, freq,ans);

            if(str!=""){
                return str;
            }

            ans.deleteCharAt(ans.length()-1);
            freq[t-'a']++;
        }
        int x = t-'a';
        for( int i = x+1; i < 26; i++){
            if(freq[i]>0){
                ans.append((char)(i+'a'));
                freq[i]--;
                for( int j =0; j < 26; j++){
                    while(freq[j] > 0){
                        ans.append((char)(j+'a'));
                        freq[j]--;
                    }
                }
                return ans.toString();
            }
            
        }
        return "";
    }
}