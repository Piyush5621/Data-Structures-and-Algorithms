class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int ans = 0;
        for( int i = 0 ; i < n; i++ ){
            
            int first = colors[i];
            int second = colors[(i+1) % n];
            int third = colors[(i+2) % n];

            if(first != second && second != third ) ans++;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna