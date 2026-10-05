class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int freq[] = new int[101];
        int maxm = 0;
        for( int x : nums){
            freq[x]++;
            maxm = Math.max(freq[x],maxm);
        }
        int ans[] = new int[n];
        int c = 0;
        for( int i = 0; i < maxm; i++ ){
            for( int j = 1; j < 101; j++ ){
                if(freq[j] > 0){
                    ans[c++] = j;
                    freq[j]--;
                } 
            }
        }
        return ans;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna