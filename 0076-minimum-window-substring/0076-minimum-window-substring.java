class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        int[] freq = new int[128];
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            freq[ch]++;
        }

        int req = t.length();
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (freq[ch] > 0) {
                req--;
            }
            freq[ch]--;

            while (req == 0) {
                char cl = s.charAt(left);
                if ( (right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                freq[cl]++;
                if( freq[cl] > 0){
                    req++;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "": s.substring(start , start+minLen);

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna