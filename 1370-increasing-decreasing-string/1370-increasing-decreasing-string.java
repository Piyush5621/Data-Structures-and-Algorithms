class Solution {
    public String sortString(String s) {
        int freq[] = new int[26];
        for( char c : s.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder str = new StringBuilder();
        int n = s.length();
        boolean flip = false;
        while(str.length() < n){
            if(!flip){
                for( int i = 0; i< 26; i++){
                    if(freq[i]>0){
                        str.append((char)(i+'a'));
                        freq[i]--;
                    }
                }
            }
            else{
                for( int i = 25; i>= 0; i--){
                    if(freq[i]>0){
                        str.append((char)(i+'a'));
                        freq[i]--;
                    }
                }
            }
            flip = !flip;
        }
        return str.toString();
    }
}