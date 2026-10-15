class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int maxLen  = 0 ;
        int left = 0;
        int currCost = 0;
        for( int i = 0 ; i < s.length(); i++ ){
            char ch = s.charAt(i);

            if(ch != t.charAt(i)){
                currCost += Math.abs(ch - t.charAt(i));
            }

            while( currCost > maxCost ){
                currCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }

            maxLen = Math.max(maxLen, i - left + 1);
        }

        return maxLen;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna