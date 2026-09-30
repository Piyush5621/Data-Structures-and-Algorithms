class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for( char c : s1.toCharArray() ){
            freq1[c -'a']++;
        }
        int left  = 0;
        int right = 0;
        int len1 = s1.length();
        while( right < s2.length() ){
            char ch = s2.charAt(right);
            freq2[ch-'a']++;
            if(right - left +1 == len1 ){
                if(check(freq1,freq2)) return true;
            }
            if(right - left + 1 < len1 ){
                right++;
            }
            else{
                freq2[s2.charAt(left)-'a']--;
                left++;
                right++;
            }
        }
        return false;
    }

    private boolean check(int freq1[], int freq2[] ){
        for( int i = 0; i < 26; i++ ){
            if( freq1[i] != freq2[i] ) return false;
        }

        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna