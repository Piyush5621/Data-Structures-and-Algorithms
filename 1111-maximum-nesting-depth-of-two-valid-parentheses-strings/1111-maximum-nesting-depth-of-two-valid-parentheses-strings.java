class Solution {
    public int[] maxDepthAfterSplit(String s) {
        int n = s.length();
        int ans[] = new int[n];

        int cnt = 0;
        for( int i = 0; i < n ; i++ ){
            char ch = s.charAt(i);
            if(ch == '('){
                ans[i] = cnt % 2;
                cnt++;
            }
            else{
                cnt--;
                ans[i] = cnt % 2;
            }
        }

        return ans;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna