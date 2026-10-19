class Solution {
    public boolean makeEqual(String[] words) {
        int freq[] = new int[26];

        for( String s : words ){
            for( char c : s.toCharArray() ){
                freq[c -'a']++;
            }
        }
        int prev = -1;
        int fre = 0;
        for( int  i= 0; i < 26; i++ ){
            if(freq[i] > 0){
                if(freq[i] % words.length != 0) return false;
                
            }
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna