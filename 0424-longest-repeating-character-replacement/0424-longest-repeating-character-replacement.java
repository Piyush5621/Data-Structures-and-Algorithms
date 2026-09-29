class Solution {
    public int characterReplacement(String s, int k) { 
        int freq[] = new int[26];

        int left = 0;
        int maxFreq = 0;
        int ans = 0;
        for( int i = 0; i < s.length(); i++ ){
            char ch = s.charAt(i);
            freq[ch -'A']++;
            
            maxFreq = Math.max(freq[ch-'A'],maxFreq);

            while((i - left + 1)- maxFreq > k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            ans = Math.max(i - left + 1, ans );
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna