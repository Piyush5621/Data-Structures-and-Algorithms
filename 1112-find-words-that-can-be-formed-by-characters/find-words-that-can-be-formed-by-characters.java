class Solution {
    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        int freq[] = new int[26];
        for( char c : chars.toCharArray()){
            freq[c-'a']++;
        }
        for( String str : words){
            int freq1[] = new int[26];
            
            for( char c : str.toCharArray() ){
                freq1[c-'a']++;
            }
            boolean exist = true;
            for( int i = 0; i< 26 ;i++ ){
                if(  freq1[i] > freq[i]){
                    exist = false;
                    break;
                }
            }
            if(exist){
                ans += str.length();
            }
        }
        return ans;
    }
}